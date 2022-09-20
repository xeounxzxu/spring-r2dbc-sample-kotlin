import org.jetbrains.kotlin.daemon.common.isDaemonEnabled
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

repositories {
    mavenCentral()
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
    apply(plugin = "kotlin")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-kapt")

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

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    }

}

project("cloud") {

    dependencies {

    }
}

project("data") {

    dependencies {

    }
}
project("boot") {

    dependencies {
        implementation(project(":cloud"))
        implementation(project(":data"))
    }
}
