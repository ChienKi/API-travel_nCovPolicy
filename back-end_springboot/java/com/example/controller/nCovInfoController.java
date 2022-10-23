package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nCovInfoController {
    /**
     无参数接口
     */
    @CrossOrigin
    @RequestMapping(value="/api/get_nCovInfo",method = RequestMethod.GET)
    public String getDefault_nCovInfo(){
        return nCovInfo.get_nCovInfo();
    }
}
