import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("convention.kotlin.library")
    id("convention.kotlin.boot")

    //spring
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


dependencies {
    api(project(":jmeter-cloud-common:jmeter-cloud-utilities"))
    implementation("jakarta.validation:jakarta.validation-api")
}