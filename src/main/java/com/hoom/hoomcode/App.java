package com.hoom.hoomcode;

import com.hoom.hoomcode.controller.index.IndexController;
import com.hoom.hoomcode.mocks.MockedRLocalCache;
import com.hoom.hoomcode.utils.Cache;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        initRedis();

        port(9090);
        staticFiles.location("/public");
        //staticFiles.expireTime(60 * 10);

        get("/", (req, resp) -> IndexController.index(req, resp));

    }


    public static void initRedis() {
        Cache.init(new MockedRLocalCache());
        //Redis.init();
        //Cache.init(Redis.getInstance().getLocalCachedMap("any", Cache.options()));
    }
}
