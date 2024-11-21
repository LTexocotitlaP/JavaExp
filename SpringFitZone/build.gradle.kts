plugins {
    application
    id("org.springframework.boot") version "3.3.6"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.5")

    compileOnly("org.projectlombok:lombok:1.18.36")

    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.1")
}

application {
    mainClass.set("org.example.fitzone.App")
}