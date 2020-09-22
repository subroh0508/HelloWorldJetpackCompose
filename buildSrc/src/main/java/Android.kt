@file:Suppress("HardcodedStringLiteral")

import org.gradle.api.Project

val Project.androidGradlePlugin get() = "com.android.tools.build:gradle:${version("android-gradle-plugin")}"
