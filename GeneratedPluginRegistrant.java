plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.marcofanti.pk_segnaletica"
    compileSdk = 35
    
    // ✅ SUPPORTO 16KB - NDK Version
    ndkVersion = "26.1.10909125"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    defaultConfig {
        applicationId = "com.marcofanti.pk_segnaletica"
        minSdk = 21
        targetSdk = 35
        versionCode = 5  
        versionName = "1.0.4"
        
        // ✅ SUPPORTO 16KB - ABI Filters per librerie native
        ndk {
            abiFilters.clear()
            abiFilters.addAll(listOf("armeabi-v7a", "arm64-v8a", "x86_64"))
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    
    // ✅ SUPPORTO 16KB - Packaging options
    packaging {
        jniLibs {
            useLegacyPackaging = false
        }
    }
}

flutter {
    source = "../.."
}