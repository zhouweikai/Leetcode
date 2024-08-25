/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.org.apache.maven.plugins.maven.compiler.plugin)
    api(libs.org.mockito.mockito.all)
    testImplementation(libs.org.junit.jupiter.junit.jupiter.engine)
}

group = "groupId"
version = "1.0-SNAPSHOT"
description = "Leetcode"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}