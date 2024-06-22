import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    id("org.asciidoctor.jvm.convert") apply false
//    id("org.jetbrains.kotlin.plugin.allopen")  // TODO(변경_포인트)
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    kotlin("jvm")
    kotlin("kapt") apply false
    kotlin("plugin.spring") apply false
    kotlin("plugin.allopen") apply false
    idea
}

allprojects {
    group = "${property("projectGroup")}"
    version = "${property("applicationVersion")}"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.asciidoctor.jvm.convert")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.jetbrains.kotlin.kapt")

    java {
        sourceCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        // fixme: gradle 내부의 function 을 고민 해보장!!
        if (!project.name.contains("callback")) {
            implementation("org.springframework.boot:spring-boot-starter-web")
        }
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "${project.property("javaVersion")}"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
