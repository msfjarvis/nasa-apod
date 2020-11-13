apply(from = "buildDependencies.gradle")
val build: Map<Any, Any> by extra

plugins {
  `kotlin-dsl`
}

repositories {
  google()
  gradlePluginPortal()
}

kotlinDslPluginOptions {
  experimentalWarning.set(false)
}

gradlePlugin {
  plugins {
    register("aps") {
      id = "apod-plugin"
      implementationClass = "PasswordStorePlugin"
    }
  }
}

dependencies {
  implementation(build.getValue("kotlinGradlePlugin"))
  implementation(build.getValue("androidGradlePlugin"))
}
