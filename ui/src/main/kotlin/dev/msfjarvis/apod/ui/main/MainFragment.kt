package dev.msfjarvis.apod.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.databinding.MainFragmentBinding
import dev.msfjarvis.apod.util.fragment.viewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {
  private val viewModel: MainViewModel by activityViewModels()
  private val binding by viewBinding(MainFragmentBinding::bind)

  companion object {
    fun newInstance() = MainFragment()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    lifecycleScope.launchWhenCreated {
      viewModel.images.collect { images ->
        withContext(Dispatchers.Main) {
          binding.message.text = images[0].explanation
        }
      }
    }
  }
}
