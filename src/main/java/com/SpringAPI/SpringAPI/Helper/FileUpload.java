package com.SpringAPI.SpringAPI.Helper;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUpload {
    public final String UPLOAD_DIR="D:\\Spring-API\\src\\main\\resources\\static\\Image";

    public  boolean uploadFile(MultipartFile multipart){
        boolean f=false;
        try {
//            InputStream inputStream =multipartFile.getInputStream();
//            byte data[]=new byte[inputStream.available()];
//            inputStream.read(data);
//
//            //write
//            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.seperator+MultipartFile.getOriginalFilename());
//            fos.write(data);
//            fos.close();
//            inputStream.close()
           Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            f=true;


        }catch (Exception e){
            e.printStackTrace();
        }
        return f;

    }
}
