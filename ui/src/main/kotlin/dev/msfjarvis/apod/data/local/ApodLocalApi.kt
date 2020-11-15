package dev.msfjarvis.apod.data.local

import android.content.Context
import com.squareup.moshi.JsonAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.data.remote.ApodApi
import javax.inject.Inject

class ApodLocalApi @Inject constructor(
  @ApplicationContext private val context: Context,
  private val jsonAdapter: JsonAdapter<List<PictureDetail>>,
): ApodApi {
  override fun getImages(): List<PictureDetail> {
    val resource = context.resources.openRawResource(R.raw.data)
    val string = resource.bufferedReader().use { it.readText() }
    return jsonAdapter.fromJson(string) ?: error("Failed to parse JSON data")
  }
}
