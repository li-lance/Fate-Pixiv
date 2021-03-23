package com.fate.pixiv.login.pkce;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Author：lance.li on 3/23/21 16:57
 * email：foryun@live.com
 */
class PKCEUtil {
  public static String generateCodeVerifier() {
    SecureRandom secureRandom = new SecureRandom();
    byte[] codeVerifier = new byte[32];
    secureRandom.nextBytes(codeVerifier);
    return Base64.encodeToString(codeVerifier,
        Base64.URL_SAFE | Base64.NO_WRAP | Base64.NO_PADDING);
  }

  public static String generateCodeChallange(String codeVerifier)
      throws UnsupportedEncodingException,
      NoSuchAlgorithmException {
    byte[] bytes = codeVerifier.getBytes("US-ASCII");
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    messageDigest.update(bytes, 0, bytes.length);
    byte[] digest = messageDigest.digest();
    return Base64.encodeToString(digest, Base64.URL_SAFE | Base64.NO_WRAP | Base64.NO_PADDING);
  }
}
