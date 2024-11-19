plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.0")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.1.0-alpha1")
}

application {
    mainClass.set("org.example.zonafit.App")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
