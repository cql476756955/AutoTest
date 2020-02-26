package com.course;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class getCookie {

    @RequestMapping(value = "/getCookieDemo",method = RequestMethod.GET)
    public String getCookie(HttpServletResponse response){
        System.out.println("get cookies ");
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "get cookies";

    }
//*
// 要求客户携带cookie才能访问get请求
// */

    @RequestMapping(value = "/get/withCookie",method = RequestMethod.GET)
    public  String getWithCookies(HttpServletRequest request){
       Cookie[] cookies =  request.getCookies();
       if(Objects.isNull(cookies)){
               return "没有携带cookies错误";
        }

       for (Cookie cookie : cookies){
           if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
               return "访问成功";
           }
       }

        return "以已经携带cookies";
    }

    /*
    * 携带参数的get请求
    *
    * */

    @RequestMapping(value = "/get/value",method = RequestMethod.GET)
    public Map<String,Integer> getvValue(@RequestParam Integer name,@RequestParam Integer value){
        Map mapList = new HashMap<>();

        mapList.put("name",10);
        mapList.put("age",11);

        return mapList;
    }

}


