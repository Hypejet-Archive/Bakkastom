rootProject.name = "Bakkastom"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()

        maven("https://jitpack.io")
        maven("https://storehouse.okaeri.eu/repository/maven-public")
        maven {
            name = "hypejet"
            url = uri("https://repo.hypejet.org/private")
            credentials {
                username = System.getenv("HYPEJET_MAVEN_USERNAME")?: System.getenv("MAVEN_USERNAME")
                password = System.getenv("HYPEJET_MAVEN_PASSWORD")?: System.getenv("MAVEN_PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}