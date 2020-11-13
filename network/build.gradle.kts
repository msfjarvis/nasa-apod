plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("plugin.serialization") version "1.4.10"
  `apod-plugin`
}

dependencies {
  implementation(Dependencies.Kotlin.Ktor.clientCore)
  implementation(Dependencies.Kotlin.Ktor.clientJson)
  implementation(Dependencies.Kotlin.Ktor.clientOkHttp)
  implementation(Dependencies.Kotlin.Ktor.clientSerialization)
  testImplementation(Dependencies.Testing.junit)
  testImplementation(Dependencies.Kotlin.Ktor.clientTest)
}
