package com.example.controller;

public class Visit {
    public static String get_Visits(String city_name) {
        //java环境中文传值时，需特别注意字符编码问题
        String httpUrl = "http://api.tianapi.com/scenic/index";
        String httpArg = "key=767d51bc9cce27e05421a1a9cd7f4c4f&word="+city_name;
        String jsonResult = request.request(httpUrl, httpArg);
        System.out.println(jsonResult);
        return jsonResult;
    }
}
