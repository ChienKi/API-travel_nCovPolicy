package com.example.controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    /**
     无参数接口
     */
    @CrossOrigin
    @RequestMapping(value="/api/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }

    /**
     有参数接口
     */
    @CrossOrigin
    @RequestMapping(value = "/api/gethello", method = RequestMethod.GET)
    public String getHello(@RequestParam(value = "param") String hello) {
        System.out.println("gethello =" + hello);

        String path = System.getProperties().getProperty("server.path");
        System.out.println("path =" + path);
        return "hello = " + hello;
    }
}
