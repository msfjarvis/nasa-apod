package dev.msfjarvis.apod.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.databinding.MainFragmentBinding
import dev.msfjarvis.apod.util.fragment.viewBinding
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {
  private val viewModel: MainViewModel by activityViewModels()
  private val binding by viewBinding(MainFragmentBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val navController = findNavController()
    val adapter = ApodImagesAdapter(arrayListOf()) { detail ->
      navController.navigate(MainFragmentDirections.toDetailFragment(detail))
    }
    val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    binding.apodRecyclerView.layoutManager = layoutManager
    binding.apodRecyclerView.adapter = adapter
    lifecycleScope.launchWhenCreated {
      viewModel.images.collect { images ->
        adapter.addItems(images)
      }
    }
  }
}
