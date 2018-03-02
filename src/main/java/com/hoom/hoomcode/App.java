package com.hoom.hoomcode;

import com.hoom.hoomcode.controller.index.IndexController;
import com.hoom.hoomcode.utils.Cache;
import com.hoom.hoomcode.utils.Redis;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        initRedis();

        port(5050);
        staticFiles.location("/public");
        staticFiles.expireTime(60 * 10);

        get("/", (req, resp) -> IndexController.index(req, resp));

    }


    public static void initRedis() {
        Redis.init();
        Cache.init(Redis.getInstance().getLocalCachedMap("any", Cache.options()));
    }
}
