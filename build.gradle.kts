import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "1.4.21" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    dependencies {
        val testImplementation by configurations
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    }

    tasks {
        withType<KotlinCompile>().configureEach {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}
