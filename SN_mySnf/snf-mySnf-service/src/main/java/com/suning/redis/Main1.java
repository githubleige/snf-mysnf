package com.suning.redis;

import com.suning.redis.util.RedisUtil;

public class Main1 {
    public static void main(String[] args) {
        String str=RedisUtil.set("k2","v2");
        System.out.println(str);
    }
}
