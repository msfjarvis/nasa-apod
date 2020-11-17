/*
 * Copyright © 2014-2020 The Android Password Store Authors. All Rights Reserved.
 * SPDX-License-Identifier: GPL-3.0-only
 */

import com.android.build.gradle.TestedExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.tasks.wrapper.Wrapper
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure root project.
 * Note that classpath dependencies still need to be defined in the `buildscript` block in the top-level build.gradle.kts file.
 */
internal fun Project.configureForRootProject() {
  // register task for cleaning the build directory in the root project
  tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
  }
  tasks.withType<Wrapper> {
    gradleVersion = "6.7.1"
    distributionType = Wrapper.DistributionType.ALL
    distributionSha256Sum = "22449f5231796abd892c98b2a07c9ceebe4688d192cd2d6763f8e3bf8acbedeb"
  }
}

/**
 * Configure all projects including the root project
 */
internal fun Project.configureForAllProjects() {
  repositories {
    google()
    jcenter()
  }
  tasks.withType<KotlinCompile> {
    kotlinOptions {
      jvmTarget = JavaVersion.VERSION_1_8.toString()
      freeCompilerArgs = freeCompilerArgs + additionalCompilerArgs
      languageVersion = "1.4"
    }
  }
  tasks.withType<Test> {
    maxParallelForks = Runtime.getRuntime().availableProcessors() * 2
    testLogging {
      events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
  }
}

/**
 * Apply configurations for app module
 */
@Suppress("UnstableApiUsage")
internal fun BaseAppModuleExtension.configureAndroidApplicationOptions(project: Project) {
  val minifySwitch = project.providers.environmentVariable("DISABLE_MINIFY").forUseAtConfigurationTime()

  adbOptions.installOptions("--user 0")

  buildFeatures {
    viewBinding = true
    buildConfig = true
  }

  buildTypes {
    named("release") {
      isMinifyEnabled = !minifySwitch.isPresent
      setProguardFiles(listOf("proguard-android-optimize.txt", "proguard-rules.pro"))
    }
    named("debug") {
      versionNameSuffix = "-debug"
      isMinifyEnabled = false
    }
  }
}

/**
 * Apply baseline configurations for all Android projects (Application and Library).
 */
@Suppress("UnstableApiUsage")
internal fun TestedExtension.configureCommonAndroidOptions() {
  compileSdkVersion(30)

  defaultConfig {
    minSdkVersion(23)
    targetSdkVersion(30)
  }

  sourceSets {
    getByName("debug") {
      java.srcDirs("src/debug/kotlin")
    }
    getByName("main") {
      java.srcDirs("src/main/kotlin")
    }
    listOf("test", "testDebug", "testRelease").map {
      getByName(it) {
        java.srcDirs("src/main/kotlin")
        java.srcDirs("src/test/kotlin")
      }
    }
    listOf("androidTest", "androidTestDebug", "androidTestRelease").map {
      getByName(it) {
        java.srcDirs("src/main/kotlin")
        java.srcDirs("src/androidTest/kotlin")
      }
    }
  }

  packagingOptions {
    exclude("**/*.version")
    exclude("**/*.txt")
    exclude("**/*.kotlin_module")
    exclude("**/plugin.properties")
  }

  compileOptions {
    isCoreLibraryDesugaringEnabled = true
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  testOptions.animationsDisabled = true
}
