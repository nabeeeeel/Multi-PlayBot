import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
}

group = "me.nabeel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven{
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("me.jakejmattson:DiscordKt:0.22.0-SNAPSHOT")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}