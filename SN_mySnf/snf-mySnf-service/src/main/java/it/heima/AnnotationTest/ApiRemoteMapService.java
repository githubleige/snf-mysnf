package it.heima.AnnotationTest;


import java.lang.annotation.*;
import java.util.Map;

@Contract(
        name = "suning.api.remote.map.service",
        internal = false,
        description = "this is a suning api remote map service"
)
public interface ApiRemoteMapService {
    @Method(
            idempotent = false,
            timeout = 5000L,
            retryTimes = 0,
            priority = "H",
            description = "execute service"
    )
    Map<String, Object> execute(Map<String, Object> var1);
}


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Contract {
    boolean internal() default false;

    String name() default "";

    String description() default "";

    String warningPhones() default "";
}



@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Method {
    boolean idempotent() default true;

    long timeout() default 5000L;

    int retryTimes() default 0;

    String description() default "";

    long spanLogInterval() default 1000L;

    /** @deprecated */
    @Deprecated
    String priority() default "H";
}

