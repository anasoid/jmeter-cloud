import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("org.anasoid.jmeter.cloud.kotlin-library-conventions")
    id("org.anasoid.jmeter.cloud.kotlin-openapi-generated-conventions")
    id("org.anasoid.jmeter.cloud.kotlin-boot-conventions")
    id("org.openapi.generator") version "6.6.0"


    //spring
    id("org.springframework.boot") version "3.1.1" apply false
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.8.22"

}

apply(plugin = "convention.detekt-config")

apply(plugin = "io.spring.dependency-management")
the<DependencyManagementExtension>().apply {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

sourceSets.named("main") {
    java.srcDir("$buildDir/gensrc/src/main/kotlin")
}




dependencies {
    api(project(":jmeter-cloud-core"))
    api(project(":jmeter-cloud-api"))
    api(project(":jmeter-cloud-common-rest"))


    //Spring boot
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    //Spring swagger
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("jakarta.validation:jakarta.validation-api")


}





tasks.register<GenerateTask>("openApiGenerateApiApp") {
    description = "open api generate client"
    group = "generate openapi"
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/jmeter-cloud-api/src/main/resources/openapi/jmeter-cloud-api-0.1.0.yml")
    outputDir.set("$buildDir/gensrc")
    packageName.set("org.anasoid.jmeter.cloud.api.rest.generated")
    configOptions.set(
        mapOf(
            "basePackage" to "org.anasoid.jmeter.cloud.api.rest.generated.app",
            "delegatePattern" to "true",
            "reactive" to "true",
            "useSpringBoot3" to "true",
        )
    )

}

tasks.withType<KotlinCompile>().configureEach {
    dependsOn("openApiGenerateApiApp")
}



