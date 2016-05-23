package com.tacademy.ecommerce.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

  public static File upload(MultipartFile multipartFile, String uploadDir) {
    File dirPath = new File(uploadDir);
    if (!dirPath.exists()) {
      boolean made = dirPath.mkdirs();
      if (!made) {
        throw new RuntimeException(String.format("make directory(%s) fail", uploadDir));
      }
    }

    String targetFilePath = uploadDir + "/" + multipartFile.getOriginalFilename();
    File targetFile = new File(targetFilePath);
    try {
      multipartFile.transferTo(targetFile);
    } catch (IOException ex) {
      throw new RuntimeException(String.format("file upload error:%s", targetFilePath), ex);
    }
    return targetFile;
  }

}
