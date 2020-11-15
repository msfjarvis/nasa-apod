package dev.msfjarvis.apod.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.msfjarvis.apod.data.remote.ApodApi
import dev.msfjarvis.apod.util.date.PictureDetailComparator
import kotlinx.coroutines.flow.flow

class MainViewModel @ViewModelInject constructor(private val apodApi: ApodApi) : ViewModel() {

  val images = flow {
    emit(apodApi.getImages().sortedWith(PictureDetailComparator))
  }
}
