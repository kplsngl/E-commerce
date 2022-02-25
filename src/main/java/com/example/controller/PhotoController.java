package com.example.controller;

import com.example.service.PhotoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/photo")
@CrossOrigin
public class PhotoController {
    @Autowired
    PhotoService photoService;

//    @PostMapping("/addPhotos")
//    public String saveImage() throws IOException {
//        System.out.println("kapil");
//        String dbFileName = "DemoImage";
//        File imageFile = new File("c:\\DemoImage.png");
//       // MongoClient mongo = MongoClients.create();
//        DB db = new Mongo().getDB("eComm");
//        GridFS gfsPhoto = new GridFS( db, "photos");
//        GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
//        gfsFile.setFilename(dbFileName);
//        gfsFile.save();
//        return "done";
//    }
}
