package aotu;


import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class t1 {
    @Test(groups = "client")
    public void t1(){
        System.out.println("client1");
    }
    @Test(groups = "client")
    public void t2(){
        System.out.println("client2");
    }
    @Test(groups = "server")
    public void t3(){
        System.out.println("server1");
    }
    @Test(groups = "server")
    public void t4(){
        System.out.println("server2");
    }

    @BeforeGroups("server")
    public void before(){
        System.out.println("服务端组运行之前的方法");
    }

    @AfterGroups("client")
    public void after(){
        System.out.println("客服端之后的方法");
    }
}
