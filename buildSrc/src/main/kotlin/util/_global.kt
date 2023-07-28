@file:Suppress("PackageDirectoryMismatch")

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.*
import org.gradle.api.provider.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*



infix fun <T> Property<T>.by(value: T) = set(value)
infix fun <T> Property<T>.by(value: Provider<T>) = set(value)

internal val Project.libs get() = the<LibrariesForLibs>()
