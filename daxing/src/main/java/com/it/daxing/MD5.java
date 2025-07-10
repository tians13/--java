package com.it.daxing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
  public static String encrypt(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(input.getBytes());
      StringBuilder hexString = new StringBuilder();
      for (byte b : messageDigest) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    String input = "admin";
    String encrypted = encrypt(input);
    System.out.println("MD5 encrypted value: " + encrypted);
  }
}