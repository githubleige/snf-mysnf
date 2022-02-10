package it.heima.main;

import org.springframework.web.context.WebApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebApplicationContext.class.getName() + ".ROOT";
        System.out.println(ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }
}
