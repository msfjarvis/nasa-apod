package dev.msfjarvis.apod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commitNow
import dagger.hilt.android.AndroidEntryPoint
import dev.msfjarvis.apod.ui.main.MainFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    if (savedInstanceState == null) {
      supportFragmentManager.commitNow {
        replace(R.id.container, MainFragment.newInstance())
      }
    }
  }
}
