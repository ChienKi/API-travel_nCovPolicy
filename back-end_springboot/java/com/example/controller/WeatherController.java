package com.example.controller;

import com.example.pojo.gaode_city;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @CrossOrigin
    @RequestMapping(value="/api/getWeather",method = RequestMethod.GET)
    public String getWeather(@RequestParam(value = "city_code") String city_code){
        System.out.println("city_code="+city_code);
        return Weather.get_Weather(city_code); //乌鲁木齐 650100
    }

    @CrossOrigin
    @RequestMapping(value="/db/get_gaodeCities",method = RequestMethod.GET)
    public List<gaode_city> getCities(){
        return Weather.get_AllCities_gaode();
    }
    @CrossOrigin
    @RequestMapping(value="/db/get_gaodeCityCode",method = RequestMethod.GET)
    public gaode_city getCityCode(@RequestParam(value = "city_name") String city_name){
        return Weather.get_cityByName_gaode(city_name);
    }

}
