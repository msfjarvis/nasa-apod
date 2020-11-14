package dev.msfjarvis.apod.ui.main

import app.cash.turbine.test
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.data.remote.ApodApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.concurrent.Executors
import kotlin.time.ExperimentalTime

@OptIn(
  ExperimentalTime::class,
  ExperimentalCoroutinesApi::class,
)
class MainViewModelTest {

  @Test
  fun `view model emits pictures from flow`() = runBlocking {
    viewModel.images.test {
      assertEquals(listOf(TEST_IMAGE), expectItem())
      expectNoEvents()
    }
  }

  companion object {
    private val mainThreadSurrogate = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    private val TEST_IMAGE = PictureDetail(
      copyright = null,
      date = "2020-12-01",
      explanation = "This is a test image",
      hdUrl = "https://example.com",
      mediaType = "image",
      serviceVersion = "v1",
      title = "Test image",
      url = "https://example.com",
    )
    @JvmStatic
    private lateinit var viewModel: MainViewModel

    @BeforeClass
    @JvmStatic
    fun setUp() {
      Dispatchers.setMain(mainThreadSurrogate)
      val apodApi = object : ApodApi {
        override suspend fun getImages(): List<PictureDetail> {
          return listOf(TEST_IMAGE)
        }
      }
      viewModel = MainViewModel(apodApi)
    }

    @AfterClass
    @JvmStatic
    fun tearDown() {
      Dispatchers.resetMain()
      mainThreadSurrogate.close()
    }
  }
}
