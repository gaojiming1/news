package com.news.api;

import com.news.base.ApiBase;

abstract public class ProfileApi extends ApiBase {

    @Override
    public Result before() {
        Result result = super.before();
        if (result.state != Result.STATE_OK)
            return result;
        // if not user
//        if (!Session.getInstance().hasAccount()) {
//            result.state = Result.STATE_AUTHORIZATION_ERROR;
//            return result;
//        }
        return result;
    }

}
