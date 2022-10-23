package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class VisitController {
    /**
     无参数接口
     */
    @CrossOrigin
    @RequestMapping(value="/api/get_Visit",method = RequestMethod.GET)
    public static String get_Visits(@RequestParam(value = "city_name") String city_name){
        System.out.println("city_name="+city_name);
        return Visit.get_Visits(city_name);
    }
}
