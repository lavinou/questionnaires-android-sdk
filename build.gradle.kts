// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0-RC1" apply false
    id("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.dokka") version "1.9.20" apply false
    kotlin("plugin.serialization") version "2.0.0-RC3"
    kotlin("plugin.compose") version "2.0.0-RC3"
}