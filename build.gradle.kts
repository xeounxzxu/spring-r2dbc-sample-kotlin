import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
    id("org.jetbrains.dokka") version "1.7.20"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("kapt") version "1.7.10"
}

springBoot {
    mainClass.value("com.example.webflux.BootApplication")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

allprojects {
    val javaVersion = "11"

    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    tasks.withType<JavaCompile> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {

    apply {
        plugin("kotlin")
        plugin("io.spring.dependency-management")
        plugin("kotlin-kapt")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.dokka")
    }

    val dokkaPlugin by configurations

    repositories {
        mavenCentral()
    }

    dependencies {

        // kotlin
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


        // spring
        implementation("org.springframework.boot:spring-boot-starter-aop")


        // test
        testImplementation("org.mockito:mockito-core:4.6.1")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(module = "junit")
            exclude(module = "mockito-core")
        }
        testImplementation("com.ninja-squad:springmockk:3.0.1")

        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

        // log
        implementation("io.github.microutils:kotlin-logging-jvm:2.0.10")
    }
}

