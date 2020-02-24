package aotu;

import org.testng.annotations.Test;
import java.lang.Thread;

public class TimeOut {

    @Test(timeOut = 2000)//ms机制
    public void success() throws InterruptedException {
        System.out.println("成功了");
        Thread.sleep(1999);
    }

    @Test(timeOut = 2000)//ms机制
    public void fail() throws InterruptedException {
        System.out.println("成功了");
        Thread.sleep(2500);
    }
}
