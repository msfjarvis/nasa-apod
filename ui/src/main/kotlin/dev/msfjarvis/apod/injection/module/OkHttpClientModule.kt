package dev.msfjarvis.apod.injection.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

/**
 * This module creates an [HttpClient] backed by [OkHttp].
 */
@Module
@InstallIn(ApplicationComponent::class)
object OkHttpClientModule {
  @Provides
  fun provideClient() = HttpClient(OkHttp) {
    install(JsonFeature) {
      serializer = KotlinxSerializer()
    }
    engine {
      config {
        followSslRedirects(true)
      }
    }
  }
}
