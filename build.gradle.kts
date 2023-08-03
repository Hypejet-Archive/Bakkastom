import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin)
    `maven-publish`
    id("org.jetbrains.dokka") version "1.8.20"
    `java-library`
}

group = "org.hypejet"
version = "1.0-SNAPSHOT"

dependencies {
    api(libs.platform)
    api(libs.caffeine)

    api(libs.bundles.logging)
    api(libs.bundles.kotlin)
    api(libs.bundles.config)
}

kotlin.jvmToolchain(17)

val javadocJar by tasks.register<Jar>("dokkaHtmlJar") { // dokkaJavadocJar could also be used but this looks way better, see https://imgur.com/a/6hFaIsl
    group = "documentation"
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

val sourcesJar by tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

publishing {
    repositories.maven("https://repo.hypejet.org/private") {
        credentials {
            username = System.getenv("HYPEJET_MAVEN_USERNAME")?: System.getenv("MAVEN_USERNAME")
            password = System.getenv("HYPEJET_MAVEN_PASSWORD")?: System.getenv("MAVEN_PASSWORD")
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }

    publications.create<MavenPublication>("maven") {
        artifact(javadocJar)
        artifact(sourcesJar)
        from(components["kotlin"])
    }
}