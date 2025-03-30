plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("io.spring.javaformat:spring-javaformat-gradle-plugin:0.0.43")
    implementation("net.ltgt.errorprone:net.ltgt.errorprone.gradle.plugin:4.1.0")
}