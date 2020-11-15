package dev.msfjarvis.apod.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.msfjarvis.apod.data.remote.ApodApi
import dev.msfjarvis.apod.util.date.PictureDetailComparator

class MainViewModel @ViewModelInject constructor(apodApi: ApodApi) : ViewModel() {

  /**
   * Holds parsed images from Android resources
   */
  val images = apodApi.getImages().sortedWith(PictureDetailComparator)
}
