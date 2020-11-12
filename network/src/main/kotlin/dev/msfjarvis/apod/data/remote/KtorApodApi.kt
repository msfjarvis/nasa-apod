package dev.msfjarvis.apod.data.remote

import dev.msfjarvis.apod.data.model.PictureDetail
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

/**
 * Ktor-backed implementation of [ApodApi]
 */
class KtorApodApi @Inject constructor(private val client: HttpClient) : ApodApi {
  override suspend fun getImages(): List<PictureDetail> {
    return client.get(ApodApi.JSON_URL)
  }
}
