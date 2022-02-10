package com.suning.redis;

import com.suning.framework.sedis.impl.AbstractClient;

import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String,String> ucl = System.getenv();
        System.out.println(ucl);
    }
}
