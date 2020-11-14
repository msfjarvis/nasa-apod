package dev.msfjarvis.apod.injection.module

import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.msfjarvis.apod.data.remote.ApodApi
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitApodApiModule {

  @Provides
  fun provideClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .build()
  }

  /**
   * Using [dagger.Lazy] here is a trick I picked up from Zac Sweers, which he explained in more
   * detail here: https://www.zacsweers.dev/dagger-party-tricks-deferred-okhttp-init/
   */
  @Provides
  fun provideRetrofit(client: Lazy<OkHttpClient>): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://dl.msfjarvis.dev")
      .callFactory { request -> client.get().newCall(request) }
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }

  @Provides
  fun provideApi(retrofit: Retrofit): ApodApi {
    return retrofit.create()
  }
}
