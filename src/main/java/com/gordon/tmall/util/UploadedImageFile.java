package com.gordon.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author gordon
 */
public class UploadedImageFile {
    /**
     * MultipartFile 类型的属性，用于接受上传文件的注入
     */
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
