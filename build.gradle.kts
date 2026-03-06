plugins {
    kotlin("jvm") version "1.8.21"
    id("org.jetbrains.compose") version "1.5.0"
}

repositories {
    mavenCentral()
}

kotlin {
    // Make sure your source code is in src/main/kotlin
    sourceSets["main"].kotlin.srcDirs("src")
}

dependencies {
    implementation(compose.desktop.currentOs)

    // Apache POI for Excel reading and writing
    implementation("org.apache.poi:poi:5.2.5")
    implementation("org.apache.poi:poi-ooxml:5.2.5")

    // Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

compose.desktop {
    application {
        // This must point to the package and file containing main()
        // If your main() is in src/ui/Main.kt with package 'ui', keep it as below:
        mainClass = "ui.MainKt"

        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            packageName = "GradeConverter"
            packageVersion = "1.0.0"
        }
    }
}