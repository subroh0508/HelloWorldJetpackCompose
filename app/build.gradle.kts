plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "net.subroh0508.helloworldjetpackcompose"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libraries.Jetpack.Compose.version
        kotlinCompilerVersion = kotlinVersion
    }
}

dependencies {
    implementation(kotlinStdlib)
    implementation(Libraries.Coroutines.core)
    implementation(Libraries.Coroutines.android)
    implementation(Libraries.material)
    implementation(Libraries.Jetpack.core)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.Compose.ui)
    implementation(Libraries.Jetpack.Compose.material)
    implementation(Libraries.Jetpack.Compose.uiTooling)
    implementation(Libraries.Jetpack.Lifecycle.viewModel)
    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.Jetpack.Test.Ext.junit)
    androidTestImplementation(Libraries.Jetpack.Test.Espresso.core)
}
