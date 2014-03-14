package com.news.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {
    public static final class Network {
        public static boolean isNetWorkConnected(Context context) {
            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connManager
                    .getActiveNetworkInfo();
            return networkInfo != null
                    && networkInfo.isConnectedOrConnecting();
        }

        public static int getActiveNetworkType(Context context) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo info = cm.getActiveNetworkInfo();
                if (info != null) {
                    return info.getType();
                }
            }
            return -1;
        }

        public static boolean isWifiConnected(Context context) {
            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connManager
                    .getActiveNetworkInfo();
            return networkInfo != null
                    && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
        }

        public static boolean isMobileConnected(Context context) {
            ConnectivityManager connManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connManager
                    .getActiveNetworkInfo();
            return networkInfo != null
                    && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
        }
    }

    public static final class Preference {
        public static void setLongPref(Context context, String key,
                Long value) {
            PreferenceManager.getDefaultSharedPreferences(context)
                    .edit().putLong(key, value).commit();
        }

        public static long getLongPref(Context context, String key,
                long defaultValue) {
            return PreferenceManager.getDefaultSharedPreferences(
                    context).getLong(key, defaultValue);
        }

        public static void setIntPref(Context context, String key,
                int value) {
            PreferenceManager.getDefaultSharedPreferences(context)
                    .edit().putInt(key, value).commit();
        }

        public static int getIntPref(Context context, String key,
                int defaultValue) {
            return PreferenceManager.getDefaultSharedPreferences(
                    context).getInt(key, defaultValue);
        }

        public static void setStringPref(Context context, String key,
                String value) {
            PreferenceManager.getDefaultSharedPreferences(context)
                    .edit().putString(key, value).commit();
        }

        public static String getStringPref(Context context, String key,
                String defaultValue) {
            return PreferenceManager.getDefaultSharedPreferences(
                    context).getString(key, defaultValue);
        }

        public static boolean getBooleanPref(Context context,
                String key, boolean defaultValue) {
            return PreferenceManager.getDefaultSharedPreferences(
                    context).getBoolean(key, defaultValue);
        }

        public static void setBooleanPref(Context context, String key,
                boolean value) {
            PreferenceManager.getDefaultSharedPreferences(context)
                    .edit().putBoolean(key, value).commit();
        }

        public static void removePref(Context context, String key) {
            PreferenceManager.getDefaultSharedPreferences(context)
                    .edit().remove(key).commit();
        }
    }

    public static final class SoftInput {
        public static void hide(Context context, IBinder windowToken) {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(windowToken, 0);
        }

        public static void show(Context context, View view) {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, 0);
        }
    }

    public static final class Time {
        public static String format(Date date) {
            Date currentDate = new Date();
            int n;
            long t = currentDate.getTime() - date.getTime();
            if (t < 60 * 1000) {
                return "刚刚";
            } else if (t < 60 * 60 * 1000) {
                n = (int) (t / (60 * 1000) % 60);
                return n + "分钟前";
            } else if (t < 60 * 60 * 24 * 1000) {
                n = (int) (t / (3600 * 1000) % 24);
                return n + "小时前";
            } else if (t < 86400 * 7 * 1000) {
                n = (int) (t / (86400 * 1000) % 7);
                return n + "天前";
            }
            SimpleDateFormat dfs = new SimpleDateFormat(
                    "MM-dd HH:mm");
            return dfs.format(date);
        }
    }

    public static Date utud(int t) {
        return new Date(t * 1000);
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    static public boolean TextEmpty(String str) {
        return (str == null || str.length() == 0);
    }

}
