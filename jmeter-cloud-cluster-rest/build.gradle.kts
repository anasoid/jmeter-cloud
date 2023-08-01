import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    id("convention.kotlin.library")
    id("convention.openapi.generate")
    id("convention.kotlin.boot")

    // spring
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency)
    kotlin("plugin.spring") version libs.versions.kotlin.get()
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
    api(project(":jmeter-cloud-common-rest"))
}

val registerGenerateApi: (String, String, String, String) -> Unit by extra

registerGenerateApi(
    "openApiGenerateApiCluster",
    "cluster",
    "$rootDir/jmeter-cloud-cluster-rest/src/main/resources/openapi/jmeter-cloud-cluster-0.1.0.yml",
    "org.anasoid.jmeter.cloud.cluster.rest.generated"
)
