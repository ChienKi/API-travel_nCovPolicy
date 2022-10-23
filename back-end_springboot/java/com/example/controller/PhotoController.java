package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {
    /**
     无参数接口
     */
    @CrossOrigin
    @RequestMapping(value="/api/get_Photo",method = RequestMethod.GET)
    public String get_Photo(){
        return Photo.get_Photo();
    }
}
