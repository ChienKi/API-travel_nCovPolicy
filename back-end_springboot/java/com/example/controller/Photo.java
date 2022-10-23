package com.example.controller;

public class Photo {
    public static String get_Photo() {
        //java环境中文传值时，需特别注意字符编码问题
        String httpUrl = "https://v2.alapi.cn/api/one/photo";
        String httpArg = "token=8F48dDe82Fs8ch1V";
        String jsonResult = request.request(httpUrl, httpArg);
        System.out.println(jsonResult);
        return jsonResult;
    }
}
