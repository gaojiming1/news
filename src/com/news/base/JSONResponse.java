package com.news.base;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONResponse {

    JSONObject res;

    public int getStatus() {
        return res.optInt("status", -20000);
    }

    public boolean success() {
        return (getStatus() == 10000);
    }

    public Object getData() throws JSONException {
        Object obj = res.get("data");
        if (obj == JSONObject.NULL)
            throw new JSONException("response data is null");
        return obj;
    }

    public void parse(String string) throws JSONException {

        res = (JSONObject) new JSONObject(string);

    }
}
