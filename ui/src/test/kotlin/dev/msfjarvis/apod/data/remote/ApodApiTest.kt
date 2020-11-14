package dev.msfjarvis.apod.data.remote

import dev.msfjarvis.apod.injection.module.RetrofitApodApiModule
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

class ApodApiTest {

  @Test
  fun `missing copyright field is handled correctly`() = runBlocking {
    val pictures = apiClient.getImages()
    val copyrightedImages = pictures
      .filter { it.copyright != null }
      .count()
    assertEquals(26, pictures.size)
    assertEquals(19, copyrightedImages)
  }

  companion object {
    private val webServer = MockWebServer()
    private val apiData = getJson()
    private val apiClient = getRetrofitApi()

    /**
     * I'm doing this dance here for one reason only: Hilt.
     *
     * Hilt does not support JVM-based tests, and I do not wish to mess around with things
     * I have not used before (read: Roboelectric) so we're constructing this manually.
     */
    private fun getRetrofitApi(): ApodApi {
      val okHttp = RetrofitApodApiModule.provideClient()
      val retrofit = RetrofitApodApiModule.provideRetrofit { okHttp }
      return RetrofitApodApiModule.provideApi(retrofit)
    }

    private fun getJson(): String {
      // Load the JSON response
      val uri = this::class.java.classLoader?.getResource("data.json")
        ?: error("Failed to load sample JSON response")
      val file = File(uri.path)
      return String(file.readBytes())
    }

    @BeforeClass
    fun setUp() {
      webServer.start(8080)
      webServer.dispatcher = object : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
          return MockResponse().setBody(apiData).setResponseCode(200)
        }
      }
    }

    @AfterClass
    fun tearDown() {
      webServer.shutdown()
    }
  }
}
