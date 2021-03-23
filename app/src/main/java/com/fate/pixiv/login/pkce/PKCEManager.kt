package com.fate.pixiv.login.pkce

/**
 * Author：lance.li on 3/23/21 16:58
 * email：foryun@live.com
 */
object PKCEManager {

  fun getPKCE(): PKCEItem {
    val verify = PKCEUtil.generateCodeVerifier()
    val challenge = PKCEUtil.generateCodeChallange(verify)
    return PKCEItem(verify, challenge)
  }
}