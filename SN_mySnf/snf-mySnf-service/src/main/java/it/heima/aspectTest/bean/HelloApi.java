package it.heima.aspectTest.bean;

public class HelloApi {
    public void aspectTest(String a,String b){
        System.out.println("in aspectTest:" + "a:" + a + ",b:" + b);
//        return 0;
    }

    public int aspectTest1(String a,String b){
        System.out.println("in aspectTest:" + "a:" + a + ",b:" + b);
        return 0;
    }
}
