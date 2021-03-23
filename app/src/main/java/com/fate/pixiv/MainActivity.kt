package com.fate.pixiv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.fate.pixiv.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
//    binding.contentContainer.bindLayoutFullscreen()
    val navController = findNavController(R.id.nav_host_fragment)
//    binding.bottomNavigation.setupWithNavController(navController)
    lifecycleScope.launchWhenResumed {
      navController.addOnDestinationChangedListener { _, destination, _ ->
//        when (destination.id) {
//          R.id.homeFragment, R.id.testFragment -> binding.bottomNavigation.show()
//          else -> binding.bottomNavigation.hide()
//        }
      }
    }

  }
}

