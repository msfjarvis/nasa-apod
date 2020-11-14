package dev.msfjarvis.apod.data.remote

import dev.msfjarvis.apod.data.model.PictureDetail
import retrofit2.http.GET

/**
 * API interface for retrofit to implement.
 */
interface ApodApi {
  @GET("/nasa-apod/data.json")
  suspend fun getImages(): List<PictureDetail>
}
