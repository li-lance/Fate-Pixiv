package com.fate.pixiv

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.fate.arch.CoreFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author：lance.li on 3/8 0008 22:28
 * email：foryun@live.com
 */
class SplashFragment : CoreFragment(R.layout.fragment_splash) {
//  private val viewBinding by viewBinding(FragmentSplashBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycleScope.launch {
      delay(500)
//      toPage(R.id.action_splashFragment_to_agreementFragment)
    }
  }
}