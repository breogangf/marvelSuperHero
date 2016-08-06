package com.fivelabs.marvelsuperhero.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import retrofit.RequestInterceptor;

/**
 * Created by breogangf on 6/8/16.
 */
public class Interceptor implements RequestInterceptor {

  public static final String APIKEY = "apikey";
  public static final String TS = "ts";
  public static final String HASH = "hash";
  private String publicKey;
  private String privateKey;

  public Interceptor(String publicKey, String privateKey) {
    this.publicKey = publicKey;
    this.privateKey = privateKey;
  }

  @Override
  public void intercept(RequestFacade requestFacade) {
    long ts = System.currentTimeMillis();
    requestFacade.addEncodedQueryParam(TS, String.valueOf(ts));
    requestFacade.addEncodedQueryParam(APIKEY, publicKey);
    String hash = getHash(ts, privateKey, publicKey);
    requestFacade.addEncodedQueryParam(HASH, hash);
  }

  private String getHash(long ts, String privateKey, String publicKey) {
    String marvelHash = ts + privateKey + publicKey;
    return md5(marvelHash);
  }

  public static final String md5(final String s) {
    final String MD5 = "MD5";
    try {
      MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
      digest.update(s.getBytes());
      byte messageDigest[] = digest.digest();

      StringBuilder hexString = new StringBuilder();
      for (byte aMessageDigest : messageDigest) {
        String h = Integer.toHexString(0xFF & aMessageDigest);
        while (h.length() < 2) {
          h = "0" + h;
        }
        hexString.append(h);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
