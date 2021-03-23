package com.driver.tsla

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.driver.tsla.IMainViewModel.MainViewModel
import com.fate.arch.CoreFragment
import com.fate.core.log.Logger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * Author：lance.li on 3/5/21 13:32
 * email：foryun@live.com
 */
@AndroidEntryPoint
class MainFragment : CoreFragment(R.layout.fragment_main) {
  private val viewModel: MainViewModel by viewModels()
//  private val viewBinding by viewBinding(FragmentMainBinding::bind)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.inputs.setId("uuid")
    lifecycleScope.launchWhenResumed {
      viewModel.inputsState.collect {
        Logger.e { "state:$it" }
      }
    }
  }
}