package com.example.controller;

import com.example.mapper.CityMapper;
import com.example.pojo.gaode_city;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Weather {
    public static List<gaode_city> get_AllCities_gaode(){
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2. 获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3. 获取mapper接口代理对象
            CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);

            //4. 执行方法
            List<gaode_city> cities = cityMapper.selectAll();
            System.out.println(cities);

            //5. 释放资源
            sqlSession.close();

            return cities;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static List<gaode_city> get_citiesByName_gaode(String cityName){
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2. 获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3. 获取mapper接口代理对象
            CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);

            //4. 执行方法
            // 接收参数
            cityName = "%" + cityName + "%";
            List<gaode_city> cities = cityMapper.selectByCityName(cityName);
            System.out.println(cities);

            //5. 释放资源
            sqlSession.close();

            return cities;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static gaode_city get_cityByName_gaode(String cityName){
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2. 获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3. 获取mapper接口代理对象
            CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);

            //4. 执行方法
            // 接收参数
            cityName = "%" + cityName + "%";
            List<gaode_city> cities = cityMapper.selectByCityName(cityName);
            System.out.println(cities);

            //5. 释放资源
            sqlSession.close();

            return cities.get(0);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String get_Weather(String city_code) {
        //java环境中文传值时，需特别注意字符编码问题
        String httpUrl = "https://restapi.amap.com/v3/weather/weatherInfo";
        String httpArg = "key=358745f3794eeb0031c43722308b3cb3&city="+city_code;
        String jsonResult = request.request(httpUrl, httpArg);
        System.out.println(jsonResult);
        return jsonResult;
    }
    public static String get_TestDefaultWeather(){
        return "";
    }
}
