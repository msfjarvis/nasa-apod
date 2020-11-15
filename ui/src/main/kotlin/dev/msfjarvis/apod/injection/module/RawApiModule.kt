package dev.msfjarvis.apod.injection.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.msfjarvis.apod.data.local.ApodLocalApi
import dev.msfjarvis.apod.data.remote.ApodApi

@Module
@InstallIn(ApplicationComponent::class)
abstract class RawApiModule {
  @Binds
  abstract fun bindLocalApi(apodLocalApi: ApodLocalApi): ApodApi
}
