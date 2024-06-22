tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}

dependencies {

    // TODO : api vs implementation
//    api("dev.miku:r2dbc-mysql:0.8.2.RELEASE")

    api("io.asyncer:r2dbc-mysql:1.1.0")
    api("org.springframework.data:spring-data-r2dbc:3.2.2")
}
