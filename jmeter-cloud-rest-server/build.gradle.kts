import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("org.anasoid.jmeter.cloud.kotlin-library-conventions")
    id("org.openapi.generator") version "6.6.0"
}

dependencies {
    api(project(":jmeter-cloud-core"))
    api(project(":jmeter-cloud-api"))
}



tasks.register<GenerateTask>("openApiGenerateApiServer") {
    description = "open api generate client"
    group = "generate openapi"
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/jmeter-cloud-api/src/main/resources/openapi/jmeter-cloud-api-0.1.0.yml")
    outputDir.set("$buildDir/kotlin")
    apiPackage.set("org.anasoid.jmeter.cloud.rest.server.generated.api")
    invokerPackage.set("org.anasoid.jmeter.cloud.rest.server.generated.invoker")
    modelPackage.set("org.anasoid.jmeter.cloud.rest.server.generated.model")
    configOptions.set(
        mapOf(
            "basePackage" to "org.anasoid.jmeter.cloud.rest.server.generated",
            "delegatePattern" to "true"
        )
    )

}

tasks.register<GenerateTask>("openApiGenerateApiCluster") {
    description = "open api generate client"
    group = "generate openapi"
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/jmeter-cloud-api/src/main/resources/openapi/jmeter-cloud-cluster-0.1.0.yml")
    outputDir.set("$buildDir/kotlin")
    apiPackage.set("org.anasoid.jmeter.cloud.rest.cluster.generated.api")
    invokerPackage.set("org.anasoid.jmeter.cloud.rest.cluster.generated.invoker")
    modelPackage.set("org.anasoid.jmeter.cloud.rest.cluster.generated.model")
    configOptions.set(
        mapOf(
            "basePackage" to "org.anasoid.jmeter.cloud.rest.cluster.generated",
            "delegatePattern" to "true"
        )
    )

}
