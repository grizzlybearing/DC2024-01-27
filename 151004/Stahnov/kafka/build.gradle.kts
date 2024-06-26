plugins {
    java
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

allprojects{
    group = "com.distributed_computing"
    version = "0.0.1-SNAPSHOT"

    apply{plugin("java")}
    apply{plugin("org.springframework.boot")}
    apply{plugin("io.spring.dependency-management")}

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")

        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.modelmapper:modelmapper:3.0.0")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")

        implementation("org.springframework.kafka:spring-kafka:3.1.3")

    }

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}