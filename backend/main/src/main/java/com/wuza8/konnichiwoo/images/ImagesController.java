package com.wuza8.konnichiwoo.images;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

@RestController
class ImagesController {
    private static final String UPLOAD_DIR = "/home/user/konnichiwoo/Konnichiwoo/www/src/images/";

    @PostMapping("/images/upload")
    public String handleImageUpload(@RequestBody MultipartFile file) {
        try {
            String fileExtension = ".jpg";
            String[] ex = file.getOriginalFilename().split(".");
            if(ex.length>1)
                fileExtension = ex[ex.length-1];

            String fileName = getRandomName() + fileExtension;
            String filePath = UPLOAD_DIR + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL!";
        }
    }

    private String getRandomName(){
        int length = 4;

        // Generate random bytes
        String name = "";
        SecureRandom secureRandom = new SecureRandom();

        for(int i=0;i<length;i++){
            name += secureRandom.nextInt();
        }

        return name;
    }
}
