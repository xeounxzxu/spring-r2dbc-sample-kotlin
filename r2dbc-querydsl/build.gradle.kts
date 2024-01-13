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

    // webflux
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.68.Final:osx-aarch_64")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    //
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    // add querydsl lib
    implementation("com.infobip:infobip-spring-data-r2dbc-querydsl-boot-starter:7.2.0")
    kapt("com.infobip:infobip-spring-data-jdbc-annotation-processor-common:7.2.0")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.r2dbc:r2dbc-h2:0.9.1.RELEASE")

    //
    implementation(project(":r2dbc-data"))
}
