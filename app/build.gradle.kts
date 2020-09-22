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
        kotlinCompilerVersion = "1.4.0"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${version("kotlin")}")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.compose.ui:ui:${Libraries.Jetpack.Compose.version}")
    implementation("androidx.compose.material:material:${Libraries.Jetpack.Compose.version}")
    implementation("androidx.ui:ui-tooling:${Libraries.Jetpack.Compose.version}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha06")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
