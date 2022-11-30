import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "1.7.22" apply false
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
}

detekt {
    toolVersion = "1.21.0"
    buildUponDefaultConfig = true
    config = files("detekt/detekt.yml")

    val sources = subprojects.flatMap {
        listOf(
            "${it.projectDir}/src/main/kotlin",
            "${it.projectDir}/src/test/kotlin"
        )
    }
    source = files(sources)
}

project.dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    jvmTarget = "11"
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        val testImplementation by configurations
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
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
