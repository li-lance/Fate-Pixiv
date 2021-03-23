package com.driver.tsla

import android.app.Application
import com.driver.tsla.services.ApiService
import com.fate.core.Build
import com.fate.core.Environment
import com.fate.network.createRetrofit
import com.fate.network.moshi
import com.fate.network.okhttp3Logger
import com.fate.oauth.wechat.WxConfig
import com.squareup.moshi.Moshi
import com.tencent.mmkv.MMKV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Author：lance.li on 3/4/21 10:44
 * email：foryun@live.com
 */
@Module
@InstallIn(SingletonComponent::class)
object PixivModule {
  @Singleton
  @Provides
  fun provideBuild(): Build {
    return Build(
      BuildConfig.VERSION_CODE,
      BuildConfig.VERSION_NAME,
      BuildConfig.DEBUG,
      BuildConfig.APPLICATION_ID
    )
  }

  @Singleton
  @Provides
  fun provideMMKV(): MMKV {
    return MMKV.defaultMMKV(MMKV.SINGLE_PROCESS_MODE, "2931AF33D240AA30703A370F6FCF9166BA078AD7")!!
  }

  @Singleton
  @Provides
  fun provideEnvironment(build: Build, application: Application, kv: MMKV): Environment {
    return Environment(application.applicationContext, "https://pokeapi.co/api/v2/", build, kv)
  }

  @Singleton
  @Provides
  fun provideWxConfig(): WxConfig {
    return WxConfig("", "")
  }

  @Singleton
  @Provides
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .okhttp3Logger(BuildConfig.DEBUG)
      .build()
  }

  @Singleton
  @Provides
  fun provideMoshi(): Moshi {
    return moshi()
  }

  @Singleton
  @Provides
  fun provideRetrofit(
    okHttpClient: OkHttpClient,
    moshi: Moshi,
    environment: Environment
  ): Retrofit {
    return createRetrofit(environment.host, okHttpClient, moshi)
  }

  @Singleton
  @Provides
  fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
  }

}