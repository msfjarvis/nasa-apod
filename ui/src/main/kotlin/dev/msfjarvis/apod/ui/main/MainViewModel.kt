package dev.msfjarvis.apod.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.msfjarvis.apod.data.local.persistence.ImageEntity
import dev.msfjarvis.apod.data.local.persistence.SavedPostsDatabase
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.data.remote.ApodApi
import dev.msfjarvis.apod.util.date.PictureDetailComparator

class MainViewModel @ViewModelInject constructor(
  apodApi: ApodApi,
  database: SavedPostsDatabase,
) : ViewModel() {

  private val imagesDao = database.imagesDao()

  /**
   * Holds parsed images from Android resources
   */
  val images = apodApi.getImages().sortedWith(PictureDetailComparator)

  fun toggleSavedState(image: PictureDetail): Boolean {
    return if (imagesDao.isImageSaved(image.date)) {
      imagesDao.removeSavedImage(ImageEntity(image))
      false
    } else {
      imagesDao.saveImage(ImageEntity(image))
      true
    }
  }

  fun getSavedImages(): List<PictureDetail> {
    return imagesDao.getAllImages().map { it.image }
  }
}
