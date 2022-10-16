package com.SpringAPI.SpringAPI.Controllers;


import com.SpringAPI.SpringAPI.Helper.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @Autowired
    private FileUpload fileUpload;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file){
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());
//        System.out.println(file.isEmpty());
        try {

            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg is allow");
            }

            //file upload code
            boolean f = fileUpload. uploadFile(file);
            if(f){
               return ResponseEntity.ok("File Uploaded");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong try again");

    }


}
