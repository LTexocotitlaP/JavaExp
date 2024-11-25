plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter
    implementation("org.springframework.boot:spring-boot-starter:3.4.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.5")

    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.1")

    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass.set("org.example.fitzone.App")
}
