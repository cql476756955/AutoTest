package com.course.controller;


import com.course.model.User;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
public class Demo {

    //获取执行sql的对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getCount",method = RequestMethod.GET)
    public int getCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public  int addUser(@RequestBody User user){

        int result =  template.insert("addUser",user);
        return result;
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){

        return  template.update("updateUser",user);

    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int delUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }
}
