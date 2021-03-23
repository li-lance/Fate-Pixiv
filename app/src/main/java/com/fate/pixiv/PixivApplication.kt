package com.driver.tsla

import com.fate.arch.CoreApplication
import com.fate.core.libs.initMMKV
import com.fate.core.log.initLogger
import dagger.hilt.android.HiltAndroidApp

/**
 * Author：lance.li on 3/4/21 10:33
 * email：foryun@live.com
 */
@HiltAndroidApp
class PixivApplication : CoreApplication() {
  override fun onCreate() {
    super.onCreate()
    initLogger(BuildConfig.DEBUG)
    initMMKV()
  }
}