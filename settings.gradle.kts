pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.6.0"
}

rootProject.name = "jmeter-cloud"
include(
    "jmeter-cloud-app",
    "jmeter-cloud-cluster:jmeter-cloud-cluster-rest",
    "jmeter-cloud-api:jmeter-cloud-api-rest",
    "jmeter-cloud-common:jmeter-cloud-core",
    "jmeter-cloud-common:jmeter-cloud-common-rest",
    "jmeter-cloud-common:jmeter-cloud-utilities"
)

include("buildUtils:code-coverage-report")
