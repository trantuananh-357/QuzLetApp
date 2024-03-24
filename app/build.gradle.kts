plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("dagger.hilt.android.plugin")
//    id("androidx.navigation.safeargs")

}

android {
    namespace = "com.example.quizletapp2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quizletapp2"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    val coroutineVer = "1.7.3"


    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVer")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVer")


    //Dagger - Hilt



    val hiltVersion = "2.51"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    kapt("androidx.hilt:hilt-compiler:1.2.0")
//    kapt("androidx.hilt:hilt-compiler:1.2.0")




    //Room

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    //Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:room_version")

    implementation("androidx.compose.ui:ui-tooling:1.6.2")
    kapt("org.xerial:sqlite-jdbc:3.41.2.2")

    //Navigation
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.compose.material:material-icons-extended:1.6.3")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    // navigation 2
    implementation("io.github.raamcosta.compose-destinations:core:1.5.9-beta")
    kapt("io.github.raamcosta.compose-destinations:ksp:1.5.9-beta")

    //data store
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    implementation("com.exyte:animated-navigation-bar:1.0.0")


    //FlipCard
    implementation ("com.wajahatkarim:flippable:1.5.4")


    implementation("io.coil-kt:coil:2.6.0")







    implementation ("androidx.compose.material:material:1.6.3")
    implementation ("androidx.compose.material:material-icons-extended:1.6.3")

    implementation ("androidx.graphics:graphics-shapes:1.0.0-alpha05")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}