package com.news.base;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

import com.news.api.RequestError;
import com.news.util.LogHelperDebug;

public class JSONRequest {
    private static final String TAG = "JSONRequest";
    String mMethod = "GET";
    String mUrl;
    String mContent = null;
    String mUserAgent;
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    int mError;
    JSONResponse res = new JSONResponse();

    public JSONRequest setUrl(String url) {
        this.mUrl = url;
        return this;
    }

    public JSONRequest setMethod(String method) {
        this.mMethod = method;
        return this;
    }

    public JSONRequest setUserAgent(String userAgent) {
        mUserAgent = userAgent;
        return this;
    }

    public JSONRequest addParam(String name, String val) {
        this.params.add(new BasicNameValuePair(name, val));
        return this;
    }

    public JSONRequest addParam(String name, int val) {
        this.params.add(new BasicNameValuePair(name, String
                .valueOf(val)));
        return this;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONResponse getJSONResponse() {
        return this.res;
    }

    public void execute() {

        HttpURLConnection connection = null;

        String content = "";

        try {
            LogHelperDebug.d(TAG, "url is " + mUrl);
            URL address_url = new URL(mUrl);
            connection = (HttpURLConnection) address_url
                    .openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod(mMethod);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("user-agent", mUserAgent);

            // TODO 如果你传参数，目前只有UTF-8，无法传其它编码格式的参数
            if (params.size() != 0) {
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os,
                                "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
            }

            // connection.connect();

            byte[] buffer = new byte[8192];
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                int len = 0;

                while ((len = in.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }

                this.mContent = outStream.toString();
                res.parse(this.mContent);
                if (!res.success()) {
                    mError = RequestError.ERROR_CLIENT_ERROR;
                }
            }
        } catch (JSONException e) {
            mError = RequestError.ERROR_PARSE_ERROR;
        } catch (IOException e) {
            mError = RequestError.ERROR_NETWORK_RW_ERROR;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

    private String getQuery(List<NameValuePair> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            if (pair.getValue() == null)
                continue;
            LogHelperDebug.d(
                    TAG,
                    "param is" + URLEncoder.encode(pair.getName(), "UTF-8") + "="
                            + URLEncoder.encode(pair.getValue()));
            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(),
                    "UTF-8"));
        }
        LogHelperDebug.d(TAG, "result" + result.toString());
        return result.toString();
    }

    public int getError() {
        return mError;
    }
}
