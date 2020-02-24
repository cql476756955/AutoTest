package com;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExtentReport {
    @Test
    public void t1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void t2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void t3(){
        Assert.assertEquals("aaa","aaa");
    }
    @Test
    public void log3(){
        Reporter.log("自己的日志");
        throw new RuntimeException("自己的异常");
    }

}
