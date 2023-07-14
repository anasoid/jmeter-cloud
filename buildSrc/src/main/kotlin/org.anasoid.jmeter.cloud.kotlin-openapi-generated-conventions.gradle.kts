plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
}


dependencies {


    val kotlinxCoroutinesVersion = "1.6.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$kotlinxCoroutinesVersion")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.0")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.15")


}
