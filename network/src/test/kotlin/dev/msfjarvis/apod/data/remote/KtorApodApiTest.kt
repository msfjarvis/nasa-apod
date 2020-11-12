package dev.msfjarvis.apod.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

class KtorApodApiTest {

  companion object {
    @JvmStatic
    private lateinit var client: HttpClient

    @JvmStatic
    private lateinit var apiClient: ApodApi

    private fun getJson(): String {
      // Load the JSON response
      val uri = this::class.java.classLoader?.getResource("data.json")
        ?: error("Failed to load sample JSON response")
      val file = File(uri.path)
      return String(file.readBytes())
    }

    @JvmStatic
    @BeforeClass
    fun setUp() {
      client = HttpClient(MockEngine) {
        install(JsonFeature) {
          serializer = KotlinxSerializer()
        }
        engine {
          addHandler { request ->
            when (request.url.fullPath) {
              "/nasa-apod/data.json" -> {
                val responseHeaders = headersOf("Content-Type" to listOf("application/json"))
                respond(getJson(), headers = responseHeaders)
              }
              else -> error("Unhandled ${request.url.fullPath}")
            }
          }
        }
      }
      apiClient = KtorApodApi(client)
    }

    @JvmStatic
    @AfterClass
    fun tearDown() {
      client.close()
    }
  }

  @Test
  fun `missing copyright field is handled correctly`() = runBlocking {
    val pictures = apiClient.getImages()
    val copyrightedImages = pictures
      .filter { it.copyright != null }
      .count()
    assertEquals(26, pictures.size)
    assertEquals(19, copyrightedImages)
  }
}
