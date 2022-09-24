plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
}

dependencies {
}
