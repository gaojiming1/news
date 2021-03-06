package com.news.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import android.util.Log;

public class LogHelper {
    public static final String TAG = "BitMedia";

    public static void d(String subTag, String msg) {
        Log.d(TAG, getLogMsg(subTag, msg));
    }

    public static void i(String subTag, String msg) {
        Log.i(TAG, getLogMsg(subTag, msg));
    }

    public static void w(String subTag, String msg) {
        Log.w(TAG, getLogMsg(subTag, msg));
    }

    public static void w(String subTag, String msg, Throwable e) {
        Log.w(TAG, getLogMsg(subTag, msg + " Exception: " + getExceptionMsg(e)));
    }

    public static void e(String subTag, String msg) {
        Log.e(TAG, getLogMsg(subTag, msg));
    }

    public static void e(String subTag, String msg, Throwable e) {
        Log.e(TAG, getLogMsg(subTag, msg + " Exception: " + getExceptionMsg(e)));
    }

    private static String getLogMsg(String subTag, String msg) {
        return "[" + subTag + "] " + msg;
    }

    protected static String getExceptionMsg(Throwable e) {
        StringWriter sw = new StringWriter(1024);
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.close();
        return sw.toString();
    }
}
