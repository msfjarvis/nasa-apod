package dev.msfjarvis.apod.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.databinding.DetailFragmentBinding
import dev.msfjarvis.apod.util.fragment.viewBinding

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment) {

  private val binding by viewBinding(DetailFragmentBinding::bind)
  private val args: DetailFragmentArgs by navArgs()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val picture = args.pictureDetail
    binding.apply {
      detailImage.load(picture.hdUrl) {
        crossfade(true)
        placeholder(R.drawable.placeholder)
      }
      if (picture.copyright != null) {
        detailCopyright.isVisible = true
        detailCopyright.text = picture.copyright
      }
      detailTitle.text = picture.title
      detailExplanation.text = picture.explanation
    }
  }
}
