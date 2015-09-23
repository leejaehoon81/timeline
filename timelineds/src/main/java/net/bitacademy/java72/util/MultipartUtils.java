package net.bitacademy.java72.util;

public class MultipartUtils {
  private static int count = 0;

  public static String getFilename(String originName) {
    if (count > 1000) count = 0;
    int dotLoc = originName.lastIndexOf(".");
    return System.currentTimeMillis()
        + "_" + (++count) + originName.substring(dotLoc);
  }
  
  public static void main(String[] args) {
     String str =  MultipartUtils.getFilename("test@test.com");
     System.out.println("..."+ str);
  }
}







