package dev.msfjarvis.apod.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.data.remote.ApodApi
import dev.msfjarvis.apod.util.date.PictureDetailComparator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val apodApi: ApodApi) : ViewModel() {

  private val _images = MutableStateFlow<List<PictureDetail>>(emptyList())
  val images: StateFlow<List<PictureDetail>> = _images

  init {
    viewModelScope.launch {
      _images.value = apodApi.getImages().sortedWith(PictureDetailComparator)
    }
  }
}
