package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TravelPolicyController {

    @CrossOrigin
    @RequestMapping(value="/api/TravelPolicy/getByFromTo",method = RequestMethod.GET)
    public String get_TravelPolicy(@RequestParam(value="from") String from, @RequestParam(value="to") String to){
        System.out.println("from="+from);
        System.out.println("to="+to);
        return TravelPolicy.get_TravelPolicy(from,to);
    }

    @CrossOrigin
    @RequestMapping(value="/api/TravelPolicy/getDefaultPolicy",method = RequestMethod.GET)
    public String get_TestPolicy(){
        return TravelPolicy.get_TestDefaultPolicy();
    }

    @CrossOrigin
    @RequestMapping(value="/api/TravelPolicy/getCityCodes",method = RequestMethod.GET)
    public String get_CityCodes(){
        return TravelPolicy.get_CityCodes();
    }

    @CrossOrigin
    @RequestMapping(value="/api/TravelPolicy/getDefaultCityCodes",method = RequestMethod.GET)
    public String get_DefaultCityCodes(){
        return TravelPolicy.get_DefaultCityCodes();
    }
}
