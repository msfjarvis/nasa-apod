plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  kotlin("plugin.serialization") version "1.4.10"
  id("dagger.hilt.android.plugin")
  id("androidx.navigation.safeargs.kotlin")
  `apod-plugin`
}

android {
  defaultConfig {
    applicationId = "dev.msfjarvis.apod"
    versionCode = 1_00_00
    versionName = "1.0.0-alpha01"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  lintOptions {
    isAbortOnError = true
    isCheckReleaseBuilds = false
  }
}

dependencies {
  kapt(Dependencies.AndroidX.Hilt.daggerCompiler)
  kapt(Dependencies.AndroidX.Hilt.daggerHiltCompiler)
  kapt(Dependencies.ThirdParty.moshiKotlinCodegen)
  compileOnly(Dependencies.AndroidX.annotation)
  implementation(Dependencies.AndroidX.activity_ktx)
  implementation(Dependencies.AndroidX.appcompat)
  implementation(Dependencies.AndroidX.constraint_layout)
  implementation(Dependencies.AndroidX.core_ktx)
  implementation(Dependencies.AndroidX.fragment_ktx)
  implementation(Dependencies.AndroidX.lifecycle_common)
  implementation(Dependencies.AndroidX.lifecycle_livedata_ktx)
  implementation(Dependencies.AndroidX.lifecycle_viewmodel_ktx)
  implementation(Dependencies.AndroidX.material)
  implementation(Dependencies.AndroidX.navigationFragmentKtx)
  implementation(Dependencies.AndroidX.navigationUiKtx)
  implementation(Dependencies.AndroidX.recycler_view)

  implementation(Dependencies.Kotlin.Coroutines.android)
  implementation(Dependencies.Kotlin.Coroutines.core)
  implementation(Dependencies.Kotlin.Serialization.json)

  implementation(Dependencies.AndroidX.Hilt.dagger)
  implementation(Dependencies.AndroidX.Hilt.hiltLifecycleViewmodel)
  implementation(Dependencies.ThirdParty.coil)
  implementation(Dependencies.ThirdParty.moshi)
  implementation(Dependencies.ThirdParty.plumber)
  implementation(Dependencies.ThirdParty.timber)
  implementation(Dependencies.ThirdParty.timberkt)
  coreLibraryDesugaring(Dependencies.AndroidX.coreLibraryDesugaring)

  debugImplementation(Dependencies.ThirdParty.leakcanary)

  // Testing-only dependencies
  androidTestImplementation(Dependencies.Testing.junit)
  androidTestImplementation(Dependencies.Testing.kotlin_test_junit)
  androidTestImplementation(Dependencies.Testing.AndroidX.runner)
  androidTestImplementation(Dependencies.Testing.AndroidX.rules)
  androidTestImplementation(Dependencies.Testing.AndroidX.junit_ext)
  androidTestImplementation(Dependencies.Testing.AndroidX.navigation)

  testImplementation(Dependencies.Testing.coroutines)
  testImplementation(Dependencies.Testing.junit)
  testImplementation(Dependencies.Testing.kotlin_test_junit)
}
