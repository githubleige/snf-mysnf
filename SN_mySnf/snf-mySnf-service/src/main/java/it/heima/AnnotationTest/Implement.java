package it.heima.AnnotationTest;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Implement {
    Class<?> contract() default void.class;

    String contractStr() default "";

    String implCode() default "";
}
