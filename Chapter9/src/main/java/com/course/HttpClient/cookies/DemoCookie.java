package com.course.HttpClient.cookies;

import org.testng.annotations.BeforeTest;

import java.util.Locale;
import java.util.ResourceBundle;

public class DemoCookie {
    private ResourceBundle bundle;//读取配置文件神器
    private String url;

    @BeforeTest
    public void demo(){
       bundle = ResourceBundle.getBundle("application", Locale.CHINA);//中文读取
    }
}
