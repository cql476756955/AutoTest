package com.course;

import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class myPostMethod {
    private static Cookie cookie;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String user,
                        @RequestParam(value = "password", required = true) String pwd) {
            if (user.equals("zhanghao") && pwd.equals("mima")){
                cookie = new Cookie("login","true");
                response.addCookie(cookie);
                return "登录成功";
            }

            return "fail";
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u ){
        Cookie[] cookies =  request.getCookies();
        User user = new User();
        for(Cookie c: cookies){
            if(c.getName().equals("login") && c.getValue().equals("true")
                && u.getUserNmae().equals("zhanghao")){
                user.setUserNmae("xiaosan");
                user.setAge("18");
                user.setSex("男");

                return user.toString();
            }
        }
        return "fail";
    }
}
