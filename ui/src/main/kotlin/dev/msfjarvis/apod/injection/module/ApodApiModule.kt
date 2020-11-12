package dev.msfjarvis.apod.injection.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.msfjarvis.apod.data.remote.ApodApi
import dev.msfjarvis.apod.data.remote.KtorApodApi

/**
 * This module binds an instance of the concrete [KtorApodApi] implementation to the [ApodApi]
 * interface, allowing us to refer to [ApodApi] in our code while having an instance of [KtorApodApi]
 * be injected by Dagger.
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class ApodApiModule {
  @Binds
  abstract fun bindApodApi(realApi: KtorApodApi): ApodApi
}
