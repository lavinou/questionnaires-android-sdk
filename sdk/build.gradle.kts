plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.dokka")
    kotlin("plugin.compose")
    kotlin("plugin.serialization")
    id("maven-publish")
}

group = "com.lavinou"
version = project.findProperty("tag.version") ?: "0.1.27"

android {
    namespace = "com.lavinou.questionnaire"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String", "SDK_VERSION", "\"$version\"")
        }
        release {
//            isMinifyEnabled = true
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
            buildConfigField("String", "SDK_VERSION", "\"$version\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xjvm-default=all"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.1")

    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0-RC")

    // di
    implementation(platform("io.insert-koin:koin-bom:3.5.6"))
    implementation("io.insert-koin:koin-core")
    implementation("io.insert-koin:koin-android")
    implementation("io.insert-koin:koin-androidx-compose")

    // api
    implementation("io.ktor:ktor-client-core:2.3.11")
    implementation("io.ktor:ktor-client-cio:2.3.11")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.11")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.11")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

//Include jar with the lib's KDoc HTML.
val kdocJar by tasks.registering(Jar::class) {
    val htmlTask = tasks["dokkaHtml"]
    dependsOn(htmlTask)

    // Create the Jar from the generated HTML files.
    from(htmlTask)
    archiveClassifier.set("javadoc")
}

val releaseAar by tasks.registering(Jar::class) {
    val build = tasks["build"]
    dependsOn(build)
    from(build)
}

publishing {

    publications {

        create<MavenPublication>("SdkReleaseAar") {
            artifact(kdocJar)
            artifact(releaseAar)
            artifact("$buildDir/outputs/aar/sdk-release.aar")
            groupId = groupId
            artifactId = "questionnaire"
            version = version
            withBuildIdentifier()

            pom {

                val projectUrl = "github.com/lavinou/questionnaires-android-sdk"

                url.set("https://$projectUrl")
                name.set("Questionnaire")
                description.set("Run Questionnaires on your application to get user feedback")

                developers {
                    developer {
                        name.set("Vincent Turnier")
                        email.set("vincent@lavinou.com")
                    }
                }

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/mit-license.php")
                    }
                }

                scm {
                    url.set("https://$projectUrl/tree/main")
                    connection.set("scm:git:git://$projectUrl.git")
                    developerConnection.set("scm:git:ssh://$projectUrl.git")
                }

                withXml {
                    val dependenciesNode = asNode().appendNode("dependencies")
                    configurations.getByName("implementation") {
                        dependencies.forEach {
                            val dependencyNode = dependenciesNode.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", it.name)
                            dependencyNode.appendNode("version", it.version)
                        }
                    }
                }
            }
        }
    }
}
