plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("plugin.serialization") version "1.4.10"
  `apod-plugin`
}

dependencies {
  implementation(Dependencies.Kotlin.Ktor.clientCore)
  implementation(Dependencies.Kotlin.Serialization.json)
  testImplementation(Dependencies.Testing.junit)
  testImplementation(Dependencies.Kotlin.Ktor.clientTest)
  testImplementation(Dependencies.Kotlin.Ktor.clientJson)
  testImplementation(Dependencies.Kotlin.Ktor.clientSerialization)
}
