package com.hoom.hoomcode.controller.index;

import com.google.common.net.MediaType;
import com.hoom.hoomcode.utils.Cache;
import com.hoom.hoomcode.utils.Hash;
import com.hoom.hoomcode.utils.Path;
import com.hoom.hoomcode.utils.ViewUtils;
import spark.Request;
import spark.Response;

public class IndexController {

    public static String index(Request request, Response response) {
        String requestHash = Hash.hashRequest(request);

        if (Cache.exists(requestHash)) {
            response.type(MediaType.HTML_UTF_8.toString());
            return (String) Cache.get(requestHash);
        }

        response.type(MediaType.HTML_UTF_8.toString());
        String body = ViewUtils.render(Path.Template.INDEX);
        Cache.putAsync(Hash.hashRequest(request, Hash.HashType.FAST), body);
        return body;
    }

}
