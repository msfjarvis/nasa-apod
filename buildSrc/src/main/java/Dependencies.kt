/*
 * Copyright © 2014-2020 The Android Password Store Authors. All Rights Reserved.
 * SPDX-License-Identifier: GPL-3.0-only
 */

private const val KOTLIN_VERSION = "1.4.20"
private const val COROUTINES_VERSION = "1.4.1"
private const val ANDROIDX_HILT_VERSION = "1.0.0-alpha02"
private const val DAGGER_HILT_VERSION = "2.29.1-alpha"
private const val NAVIGATION_VERSION = "2.3.1"

object Dependencies {
  object Kotlin {
    object Coroutines {

      const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
      const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
    }

    object Serialization {

      private const val version = "1.0.1"
      const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }
  }

  object AndroidX {

    private const val lifecycleVersion = "2.3.0-beta01"

    const val activity_ktx = "androidx.activity:activity-ktx:1.2.0-beta01"
    const val annotation = "androidx.annotation:annotation:1.1.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.0-alpha02"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val core_ktx = "androidx.core:core-ktx:1.5.0-alpha04"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:1.3.0-beta01"
    const val lifecycle_common = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val lifecycle_viewmodel_ktx =
      "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val material = "com.google.android.material:material:1.3.0-alpha03"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val navigationUiKtx = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val recycler_view = "androidx.recyclerview:recyclerview:1.2.0-alpha06"
    const val viewPager = "androidx.viewpager2:viewpager2:1.1.0-alpha01"
    const val coreLibraryDesugaring = "com.android.tools:desugar_jdk_libs:1.0.10"

    object Hilt {
      const val dagger = "com.google.dagger:hilt-android:$DAGGER_HILT_VERSION"
      const val daggerCompiler = "com.google.dagger:hilt-compiler:$DAGGER_HILT_VERSION"
      const val daggerHiltCompiler = "androidx.hilt:hilt-compiler:$ANDROIDX_HILT_VERSION"
      const val hiltLifecycleViewmodel =
        "androidx.hilt:hilt-lifecycle-viewmodel:$ANDROIDX_HILT_VERSION"
    }

  }

  object ThirdParty {

    const val coil = "io.coil-kt:coil:1.0.0"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.5"
    const val moshi = "com.squareup.moshi:moshi:1.11.0"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:1.11.0"
    const val plumber = "com.squareup.leakcanary:plumber-android:2.5"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val timberkt = "com.github.ajalt:timberkt:1.5.1"
  }

  object Testing {

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$COROUTINES_VERSION"
    const val junit = "junit:junit:4.13.1"
    const val kotlin_test_junit = "org.jetbrains.kotlin:kotlin-test-junit:$KOTLIN_VERSION"

    object AndroidX {

      private const val version = "1.3.1-alpha02"
      private const val ext_version = "1.1.3-alpha02"
      const val runner = "androidx.test:runner:$version"
      const val rules = "androidx.test:rules:$version"
      const val junit_ext = "androidx.test.ext:junit-ktx:$ext_version"
      const val navigation = "androidx.navigation:navigation-testing:$NAVIGATION_VERSION"
    }
  }
}
