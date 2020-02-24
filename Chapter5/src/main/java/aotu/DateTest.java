package aotu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DateTest {

    @Test(dataProvider = "data")
    public void DateTest1(String name,int age){
        System.out.println("name = [" + name + "], age = [" + age + "]");
    }

    @DataProvider(name = "data")
    public Object[][] providerDate() {
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2222 name = [" + name + "], age = [" + age + "]");
    }

    @DataProvider(name = "methodData")
    public Object[][] methodTest(Method method){
          Object[][] o = null;
//        new Object[][]{
//                {"zhangsan",10},
//                {"lisi",20},
//                {"wangwu",30}
//        };
        if(method.getName().equals("DateTest1")){
            o = new Object[][]{
                    {"zhangsan",10},
                    {"lisi",20},
                    {"wangwu",30}
            };
        }else if (method.getName().equals("test2")){
                o = new Object[][]{
                        {"zhangsan111",10},
                        {"lisi111",20},
                        {"wangwu111",30}
            };
        }
        return o;
    }
}
