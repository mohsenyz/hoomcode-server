package com.hoom.hoomcode.utils;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Redis {

    public static RedissonClient client;

    public static void init() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(com.hoom.hoomcode.config.Config.REDIS_HOST);

        client = Redisson.create(config);
    }


    public static synchronized RedissonClient getInstance() {
        if (client == null) {
            init();
        }
        return client;
    }

}
