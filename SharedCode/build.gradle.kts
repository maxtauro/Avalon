import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.*


plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.kotlin.native.cocoapods")
}

version = "1.0"

android {
    compileSdkVersion(28)
    buildToolsVersion = "29.0.2"
    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(28)
    }
}


kotlin {

    android()
    ios("ios")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
                implementation("com.google.firebase:firebase-analytics:17.2.0")
                implementation("com.google.firebase:firebase-database:19.2.0")
            }
        }

        println("ProjectDir: $projectDir")

        configure(
            listOf(
                kotlin.targets.getByName<KotlinNativeTarget>("iosArm64"),
                kotlin.targets.getByName<KotlinNativeTarget>("iosX64")
            )
        ) {

            compilations.getByName("main") {
                val firebasecore by cinterops.creating {
                    packageName("cocoapods.FirebaseCore")
                    defFile(file("$projectDir/src/iosMain/c_interop/FirebaseCore.def"))
                    includeDirs("$projectDir/../native/Avalon/Pods/FirebaseCore/Firebase/Core/Public")
                    compilerOpts("-F$projectDir/src/iosMain/c_interop/modules/FirebaseCore")
                }

                val firebasedatabase by cinterops.creating {
                    packageName("cocoapods.FirebaseDatabase")
                    defFile(file("$projectDir/src/iosMain/c_interop/FirebaseDatabase.def"))
                    includeDirs(
                        "$projectDir/../native/Avalon/Pods/FirebaseDatabase/Firebase/Database/Public",
                        "$projectDir/../native/Avalon/Pods/FirebaseCore/Firebase/Core/Public"
                    )
                    compilerOpts("-F$projectDir/src/iosMain/c_interop/modules/FirebaseDatabase")
                }
            }
        }

        cocoapods {
            // Configure fields required by CocoaPods.
            summary = "Firebase"
            homepage = "https://github.com/maxtauro/avalon"
        }
    }
}
