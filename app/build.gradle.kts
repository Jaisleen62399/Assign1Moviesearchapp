plugins {
   alias(libs.plugins.android.application)
   alias(libs.plugins.kotlin.android)
   kotlin("kapt")
}

android {
   compileSdk = 35
   namespace = "com.jaisleen.moviesearchapp"
   defaultConfig {
      applicationId = "com.jaisleen.moviesearchapp"
      minSdk = 24
      targetSdk = 35
      versionCode = 1
      versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
   }

   buildFeatures {
      viewBinding = true  // Enable ViewBinding
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
      sourceCompatibility = JavaVersion.VERSION_11
      targetCompatibility = JavaVersion.VERSION_11
   }
   kotlinOptions {
      jvmTarget = "11"
   }
}

dependencies {
   implementation(libs.androidx.core.ktx)
   implementation(libs.androidx.appcompat)
   implementation(libs.material)
   implementation(libs.androidx.activity)
   implementation(libs.androidx.constraintlayout)
   testImplementation(libs.junit)
   androidTestImplementation(libs.androidx.junit)
   androidTestImplementation(libs.androidx.espresso.core)

   implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
   implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
   implementation("com.squareup.okhttp3:okhttp:4.11.0")
   implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
   implementation("com.github.bumptech.glide:glide:4.16.0")
   kapt("com.github.bumptech.glide:compiler:4.16.0")
   implementation("com.google.code.gson:gson:2.10.1")
}
