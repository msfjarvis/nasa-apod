/*
 * Copyright © 2014-2020 The Android Password Store Authors. All Rights Reserved.
 * SPDX-License-Identifier: GPL-3.0-only
 */

private const val KOTLIN_VERSION = "1.4.10"
private const val ANDROIDX_HILT_VERSION = "1.0.0-alpha02"
private const val DAGGER_HILT_VERSION = "2.29.1-alpha"

object Dependencies {
  object Kotlin {
    object Coroutines {

      private const val version = "1.4.1"
      const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
      const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object Ktor {

      private const val version = "1.4.1"
      const val clientCore = "io.ktor:ktor-client-core:$version"
      const val clientJson = "io.ktor:ktor-client-json:$version"
      const val clientSerialization = "io.ktor:ktor-client-serialization:$version"
      const val clientOkHttp = "io.ktor:ktor-client-okhttp:$version"
      const val clientTest = "io.ktor:ktor-client-mock:$version"
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
    const val recycler_view = "androidx.recyclerview:recyclerview:1.2.0-alpha06"

    object Hilt {
      const val dagger = "com.google.dagger:hilt-android:$DAGGER_HILT_VERSION"
      const val daggerCompiler = "com.google.dagger:hilt-compiler:$DAGGER_HILT_VERSION"
      const val daggerHiltCompiler = "androidx.hilt:hilt-compiler:$ANDROIDX_HILT_VERSION"
      const val hiltLifecycleViewmodel =
        "androidx.hilt:hilt-lifecycle-viewmodel:$ANDROIDX_HILT_VERSION"
    }

  }

  object ThirdParty {

    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.5"
    const val plumber = "com.squareup.leakcanary:plumber-android:2.5"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val timberkt = "com.github.ajalt:timberkt:1.5.1"
    const val whatthestack = "com.github.haroldadmin:WhatTheStack:0.2.0"
  }

  object Testing {

    const val junit = "junit:junit:4.13.1"
    const val kotlin_test_junit = "org.jetbrains.kotlin:kotlin-test-junit:$KOTLIN_VERSION"

    object AndroidX {

      private const val version = "1.3.1-alpha02"
      private const val ext_version = "1.1.3-alpha02"
      const val runner = "androidx.test:runner:$version"
      const val rules = "androidx.test:rules:$version"
      const val junit_ext = "androidx.test.ext:junit-ktx:$ext_version"
    }
  }
}
