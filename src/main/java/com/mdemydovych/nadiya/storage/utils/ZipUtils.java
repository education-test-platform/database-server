package com.mdemydovych.nadiya.storage.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import lombok.SneakyThrows;

public class ZipUtils {

  private ZipUtils() {

  }

  @SneakyThrows
  public static String unZipText(byte[] compressedData) {
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(compressedData)) {
      try (GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((bytesRead = gzipInputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toString(StandardCharsets.UTF_8);
      }
    }
  }

  @SneakyThrows
  public static byte[] zipText(String jsonText) {
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(jsonText.length())) {
      try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
        gzipOutputStream.write(jsonText.getBytes(StandardCharsets.UTF_8));
      }
      return outputStream.toByteArray();
    }
  }
}
