import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency)
    kotlin("plugin.spring") version libs.versions.kotlin.get()
    id("convention.kotlin.boot")
}




java {
    sourceCompatibility = JavaVersion.VERSION_17
}



apply(plugin = "convention.detekt-config")

dependencies {

    implementation(project(":jmeter-cloud-common:jmeter-cloud-core"))
    implementation(project(":jmeter-cloud-api:jmeter-cloud-api-rest"))
    implementation(project(":jmeter-cloud-cluster:jmeter-cloud-cluster-rest"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}




