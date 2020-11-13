package dev.msfjarvis.apod.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.data.remote.ApodApi
import dev.msfjarvis.apod.util.date.PictureDetailComparator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val apodApi: ApodApi) : ViewModel() {

  private val _images = MutableSharedFlow<List<PictureDetail>>()
  val images = _images.asSharedFlow()

  init {
    viewModelScope.launch {
      _images.emit(apodApi.getImages().sortedWith(PictureDetailComparator))
    }
  }
}
