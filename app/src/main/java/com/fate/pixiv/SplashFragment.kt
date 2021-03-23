package com.fate.pixiv

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fate.arch.CoreFragment
import com.fate.arch.viewbinding.viewBinding
import com.fate.pixiv.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author：lance.li on 3/8 0008 22:28
 * email：foryun@live.com
 */
@AndroidEntryPoint
class SplashFragment : CoreFragment(R.layout.fragment_splash) {
  private val viewBinding by viewBinding(FragmentSplashBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycleScope.launchWhenResumed {
      delay(500)
      toPage(R.id.action_splashFragment_to_loginFragment)
    }
    viewBinding.splashView.setOnClickListener {
      findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
    }
  }
}