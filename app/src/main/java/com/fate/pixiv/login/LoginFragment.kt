package com.fate.pixiv.login

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.fate.arch.CoreFragment
import com.fate.arch.viewbinding.viewBinding
import com.fate.core.libs.applyWindowTopAndBottomInsetAsPadding
import com.fate.core.libs.makeGone
import com.fate.pixiv.R
import com.fate.pixiv.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

/**
 * Author：lance.li on 3/23/21 16:45
 * email：foryun@live.com
 */
@AndroidEntryPoint
class LoginFragment : CoreFragment(R.layout.fragment_login) {
  @Inject @Named("login_url") lateinit var url: String
  private val viewBinding by viewBinding(FragmentLoginBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewBinding.root.applyWindowTopAndBottomInsetAsPadding()
    viewBinding.webView.webViewClient = object : WebViewClient() {
      override fun onPageFinished(view: WebView?, url: String?) {
        viewBinding.progressView.isIndeterminate =false
        viewBinding.progressView.makeGone()
        super.onPageFinished(view, url)
      }
    }
    viewBinding.webView.loadUrl(url)
  }
}