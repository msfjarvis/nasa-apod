/*
 * Copyright © 2014-2020 The Android Password Store Authors. All Rights Reserved.
 * SPDX-License-Identifier: GPL-3.0-only
 */
buildscript {
  apply(from = "buildSrc/buildDependencies.gradle")
  val build: Map<Any, Any> by extra
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath(build.getValue("androidGradlePlugin"))
    classpath(build.getValue("kotlinGradlePlugin"))
    classpath(build.getValue("daggerGradlePlugin"))
  }
}

plugins {
  id("com.github.ben-manes.versions") version "0.36.0"
  `apod-plugin`
}
