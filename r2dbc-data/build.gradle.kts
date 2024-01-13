plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

tasks.jar {
    enabled = true
}

dependencies {
    //
    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    implementation("org.springframework.data:spring-data-r2dbc")
}
