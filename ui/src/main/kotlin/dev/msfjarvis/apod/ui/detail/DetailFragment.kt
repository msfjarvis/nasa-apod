package dev.msfjarvis.apod.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.databinding.DetailFragmentBinding
import dev.msfjarvis.apod.ui.main.MainViewModel
import dev.msfjarvis.apod.util.fragment.viewBinding
import kotlin.math.abs

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment) {

  private val animate = false
  private val viewModel: MainViewModel by activityViewModels()
  private val binding by viewBinding(DetailFragmentBinding::bind)
  private val args: DetailFragmentArgs by navArgs()
  private val animator = ViewPager2.PageTransformer { page, position ->
    page.apply {
      translationY = if (animate) abs(position) * 500f else 0f
      translationX = 0f
      scaleX = 1f
      scaleY = 1f
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val viewpager = binding.viewpager
    val adapter = PictureDetailAdapter(viewModel.images)
    viewpager.setPageTransformer(animator)
    viewpager.adapter = adapter
    viewpager.setCurrentItem(args.position, false)
  }
}
