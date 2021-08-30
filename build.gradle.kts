import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.20"
    application
    java
}

java {
    sourceCompatibility = VERSION_1_8
}

group = "me.mary"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

tasks.register<JavaExec>("problem1") {
    mainClass.set("problem1.Problem1Kt")
}

tasks.register<JavaExec>("problem2") {
    mainClass.set("problem2.Problem2Kt")
}

tasks.register<JavaExec>("problem3") {
    mainClass.set("problem3.ApplicationKt")
}

tasks.withType<JavaExec>() {
    dependsOn("build")
    group = "application"
    standardInput = System.`in`
    classpath = sourceSets["main"].runtimeClasspath
}