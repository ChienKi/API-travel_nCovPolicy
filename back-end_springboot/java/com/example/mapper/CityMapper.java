package com.example.mapper;

import com.example.pojo.gaode_city;

import java.util.List;

public interface CityMapper {
    /*???????*/
    List<gaode_city> selectAll();

    List<gaode_city> selectByCityName(String city_name);
}
