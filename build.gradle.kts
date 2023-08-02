version = "0.0.1-SNAPSHOT"


plugins {
    id("org.sonarqube") version "4.2.1.3168"
}

sonar {
    properties {
        property("sonar.projectKey", "anasoid_jmeter-cloud")
        property("sonar.organization", "anasoid")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.exclusions", "**/generated/**")
        property(
            "sonar.coverage.jacoco.xmlReportPaths",
            "./buildUtils/code-coverage-report/build/reports/jacoco/testCodeCoverageReport/testCodeCoverageReport.xml"
        )
    }
}
allprojects {
    group = "org.anasoid.jmeter.cloud"
    version = rootProject.version
}
