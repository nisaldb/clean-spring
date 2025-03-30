import org.gradle.kotlin.dsl.checkstyle

plugins {
    checkstyle
    id("io.spring.javaformat")
}

repositories {
    mavenCentral()
}

dependencies {
    checkstyle("io.spring.javaformat:spring-javaformat-checkstyle:0.0.43")
}