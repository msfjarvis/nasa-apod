package dev.msfjarvis.apod.util.date

import dev.msfjarvis.apod.data.model.PictureDetail
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class LocalDateUtilsTest {

  private val firstPicture = PictureDetail(
    copyright = null,
    date = "2020-12-01",
    explanation = "This is a test image",
    hdUrl = "https://example.com",
    mediaType = "image",
    serviceVersion = "v1",
    title = "Test image",
    url = "https://example.com",
  )

  @Test
  fun `parses ISO formatted dates`() {
    assertEquals("2019-12-01".toLocalDate(), LocalDate.of(2019, 12, 1))
    assertEquals("2019-12-01+05:30".toLocalDate(), LocalDate.of(2019, 12, 1))
  }

  @Test
  fun `comparison finds older picture to be smaller`() {
    val secondPicture = PictureDetail(
      copyright = null,
      date = "2021-12-01",
      explanation = "This is a test image",
      hdUrl = "https://example.com",
      mediaType = "image",
      serviceVersion = "v1",
      title = "Test image",
      url = "https://example.com",
    )
    assertEquals(-1, PictureDetailComparator.compare(firstPicture, secondPicture))
  }

  @Test
  fun `comparison finds newer picture to be larger`() {
    val secondPicture = PictureDetail(
      copyright = null,
      date = "2018-12-01",
      explanation = "This is a test image",
      hdUrl = "https://example.com",
      mediaType = "image",
      serviceVersion = "v1",
      title = "Test image",
      url = "https://example.com",
    )
    assertEquals(1, PictureDetailComparator.compare(firstPicture, secondPicture))
  }

  @Test
  fun `comparison finds same picture to be equal`() {
    assertEquals(0, PictureDetailComparator.compare(firstPicture, firstPicture))
  }
}
