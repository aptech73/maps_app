plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.example.key_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.key_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "mobileServices"
    productFlavors {
        create ("google") {
            dimension = "mobileServices"
            applicationIdSuffix = ".google"
        }
        create ("huawei") {
            isDefault = true
            dimension = "mobileServices"
            applicationIdSuffix = ".huawei"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Map (Libre)
    "huaweiImplementation"(libs.map.libre)

    // DI (Dagger)
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.dagger.android)
    kapt(libs.dagger.processor)
    implementation(libs.dagger.android.support)

    // Async (RxJava2)
    implementation(libs.rx.android)
    implementation(libs.rx.kotlin)

    // Serialization (Kotlin)
    implementation(libs.kotlinx.serialization)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}