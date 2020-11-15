package dev.msfjarvis.apod.injection.module

import com.squareup.moshi.JsonAdapter
import dev.msfjarvis.apod.data.model.PictureDetail
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.fail

class JsonAdapterPictureDetailTest {
  private val jsonAdapter = getJsonAdapter()

  private fun getJsonAdapter(): JsonAdapter<List<PictureDetail>> {
    val moshi = MoshiModule.provideMoshi()
    return MoshiModule.provideJsonAdapterForPictureDetailList { moshi }
  }

  private fun getJson(): String {
    // Load the JSON response
    val uri = this::class.java.classLoader?.getResource("data.json")
      ?: error("Failed to load sample JSON response")
    val file = File(uri.path)
    return String(file.readBytes())
  }


  @Test
  fun `missing copyright field is handled correctly`() {
    val pictures = jsonAdapter.fromJson(getJson()) ?: fail("Failed to parse JSON response")
    val copyrightedImages = pictures.filter { it.copyright != null }
    assertEquals(26, pictures.size)
    assertEquals(19, copyrightedImages.size)
  }
}
