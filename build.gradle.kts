import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.nabeel"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.32"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.22.0-SNAPSHOT")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}