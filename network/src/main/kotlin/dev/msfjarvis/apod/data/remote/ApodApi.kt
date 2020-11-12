package dev.msfjarvis.apod.data.remote

import dev.msfjarvis.apod.data.model.PictureDetail

/**
 * Simple interface defining an API for NASA APOD
 */
interface ApodApi {
  suspend fun getImages(): List<PictureDetail>

  companion object {
    const val JSON_URL = "https://dl.msfjarvis.dev/nasa-apod/data.json"
  }
}
