package com.course.HttpClient.cookies;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class DemoCookie {
    private ResourceBundle bundle;//读取配置文件神器
    private String url;
    private CookieStore store;

    @BeforeTest
    public void demo(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);//中文读取
        url =  bundle.getString("test.url");
    }

    @Test
    public void getCookie() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url+uri;//获取拼接url

        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),("UTF-8"));

        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name
                    + ";  cookie value = " + value);
        }

    }


//    @Test
    @Test(dependsOnMethods = "getCookie")
    public void testGetWithCookies() throws IOException {

        String url =  bundle.getString("test.get.with.cookies");
        String testurl = this.url+url;
        HttpGet get = new HttpGet(testurl);
        System.out.println(testurl);

        //设置cookies信息
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response =  client.execute(get);

        int stauts = response.getStatusLine().getStatusCode();
        System.out.println("status:"+stauts);

        if(stauts == 200){
          String result =   EntityUtils.toString(response.getEntity(),"UTF-8");
          System.out.println(result);
        }

    }
}
