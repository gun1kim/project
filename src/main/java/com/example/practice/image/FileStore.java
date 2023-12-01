package com.example.practice.image;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class FileStore {

    @Value("C:/Users/kki/file/")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    public void saveFile(MultipartFile file) throws IOException {
        File outputFile = new File(fileDir);
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(file.getBytes());
        fos.close();

    }


}
