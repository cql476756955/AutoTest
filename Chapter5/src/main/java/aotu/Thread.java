package aotu;

import org.testng.annotations.Test;

public class Thread {
    @Test
    public void test1(){
        System.out.println("\n test1 Thread is"+java.lang.Thread.currentThread()+"\n");
    }
    @Test
    public void test2(){
        System.out.println("test2 Thread is"+java.lang.Thread.currentThread()+"\n");
    }
    @Test
    public void test3(){
        System.out.println("test3 Thread is"+java.lang.Thread.currentThread()+"\n");
    }
}
