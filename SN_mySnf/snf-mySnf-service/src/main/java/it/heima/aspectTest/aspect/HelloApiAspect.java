package it.heima.aspectTest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class HelloApiAspect {
    @Pointcut(value="execution(* aspectTest*(..)) && args(a1,b2)",argNames="a1,b2")
    public void pointcut1(String a1,String b2){}

//    @Before(value="pointcut1(a,b)",argNames="a,b")
    public void beforecase1(String a,String b){
        System.out.println("1 a:" + a +" b:" + b);
    }

    //注意和beforecase1的区别是argNames的顺序交换了
    //使用argNames定义的顺序来定义pointcut1(String a1,String b2)的顺序，
    // 例如：argNames="a1,b2",a1在b2前面，表示pointcut1方法第一个参数是a1，第二个参数是b2。

    //注意argNames的作用，value="pointcut1(a,b)"，argNames="x,y",
//    @Before(value="pointcut1(b,a)",argNames="b,a")
    public void beforecase2(String a,String b){
        System.out.println("2 a:" + a +" b:" + b);
    }

//    @Before(value="pointcut1(x,y)",argNames="x,y")
    public void beforecase3(String x,String y){
        System.out.println("3 a:" + x +" b:" + y);
    }

    @Around(value = "pointcut1(a,b)", argNames="a,b")
    public Object methodAround(String a,String b) throws Throwable{
        System.out.println("hello wolrd");
        Map<String,Object> map=new HashMap<>();
        return map;
    }
}
