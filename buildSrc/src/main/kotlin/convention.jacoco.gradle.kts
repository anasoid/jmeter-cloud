/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    kotlin
    jacoco
}

// Do not generate reports for individual projects
tasks.jacocoTestReport {
    enabled = true
}

jacoco {
    toolVersion = "0.8.10"
}

tasks.withType<JacocoCoverageVerification> {
    violationRules {
        rule {
            limit {
                minimum = BigDecimal(0.62)
            }
        }
    }

    afterEvaluate {
        classDirectories.setFrom(
            files(
                classDirectories.files.map {
                    fileTree(it).apply {
                        exclude("**/generated/**")
                    }
                }
            )
        )
    }
}

tasks.withType<JacocoReport> {
    afterEvaluate {
        classDirectories.setFrom(
            files(
                classDirectories.files.map {
                    fileTree(it).apply {
                        exclude("**/generated/**")
                    }
                }
            )
        )
    }
}
