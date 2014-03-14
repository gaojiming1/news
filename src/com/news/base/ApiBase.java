package com.news.base;

import com.news.api.Result;
import com.news.util.Utils;



abstract public class ApiBase {

    public Result before() {
        Result result = new Result();
        result.state = Result.STATE_OK;
        // 显示网络异常或服务器异常
        if (!Utils.Network.isNetWorkConnected(MyApplication
                .getContext())) {
            result.state = Result.STATE_NETWORK_STATE_ERROR;
        }
        return result;
    }

    public void after() {

    }

    abstract public int dstate();

    abstract public Result drun();

    abstract public Result run();

}