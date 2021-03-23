package com.driver.tsla

import android.os.Bundle
import androidx.activity.addCallback
import com.driver.tsla.R
import com.fate.arch.CoreFragment

/**
 * Author：lance.li on 3/22/21 15:05
 * email：foryun@live.com
 */
class TestFragment : CoreFragment(R.layout.fragment_test) {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requireActivity().onBackPressedDispatcher.addCallback(this) {
      requireActivity().finish()
    }
  }
}