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
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
        // developmentOnly("org.springframework.boot:spring-boot-devtools")
        implementation("io.netty:netty-resolver-dns-native-macos:4.1.68.Final:osx-aarch_64")
        implementation("org.springframework.boot:spring-boot-starter-aop")
        implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
        implementation("org.springframework.data:spring-data-r2dbc")

        // add querydsl lib
        implementation("com.infobip:infobip-spring-data-r2dbc-querydsl-boot-starter:7.2.0")
        kapt("com.infobip:infobip-spring-data-jdbc-annotation-processor-common:7.2.0")

        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
        testImplementation("io.projectreactor:reactor-test")
        testImplementation("io.r2dbc:r2dbc-h2:0.9.1.RELEASE")

        testImplementation("org.mockito:mockito-core:4.6.1")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(module = "junit")
            exclude(module = "mockito-core")
        }
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
        testImplementation("com.ninja-squad:springmockk:3.0.1")
        dokkaPlugin("org.jetbrains.dokka:versioning-plugin:1.6.0")
    }
}

