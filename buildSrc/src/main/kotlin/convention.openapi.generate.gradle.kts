import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
    id("org.openapi.generator")
}

dependencies {

    val kotlinxCoroutinesVersion = "1.8.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$kotlinxCoroutinesVersion")
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.24")

    // Spring swagger
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("jakarta.validation:jakarta.validation-api")
}

/**
 * register generate api
 */
val registerGenerateApi by extra(
    fun(name: String, desc: String, input: String, pack: String) {
        tasks.register<GenerateTask>(name) {
            description = "open api generate " + desc
            group = "generate openapi"
            generatorName.set("kotlin-spring")
            inputSpec.set(input)
            outputDir.set("$buildDir/gensrc")
            packageName.set(pack)
            configOptions.set(
                mapOf(
                    "basePackage" to pack + ".app",
                    "delegatePattern" to "true",
                    "reactive" to "true",
                    "useSpringBoot3" to "true",
                )
            )
        }
        tasks.withType<KotlinCompile>().configureEach {
            dependsOn(name)
        }
    }
)

