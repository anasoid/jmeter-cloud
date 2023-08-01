import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    base
    id("jacoco-report-aggregation")
    // spring
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency)
}

apply(plugin = "io.spring.dependency-management")

the<DependencyManagementExtension>().apply {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    jacocoAggregation(project(":jmeter-cloud-api:jmeter-cloud-api-rest"))
    jacocoAggregation(project(":jmeter-cloud-app"))
    jacocoAggregation(project(":jmeter-cloud-cluster:jmeter-cloud-cluster-rest"))
    jacocoAggregation(project(":jmeter-cloud-common:jmeter-cloud-common-rest"))
    jacocoAggregation(project(":jmeter-cloud-common:jmeter-cloud-core"))
    jacocoAggregation(project(":jmeter-cloud-common:jmeter-cloud-utilities"))
}

reporting {
    reports {
        val testCodeCoverageReport by creating(JacocoCoverageReport::class) { // <.>
            testType.set(TestSuiteType.UNIT_TEST)
        }
    }
}

tasks.check {
    dependsOn(tasks.named<JacocoReport>("testCodeCoverageReport")) // <.>
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
