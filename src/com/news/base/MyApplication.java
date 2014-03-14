package com.news.base;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;


public class MyApplication extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        sContext = getApplicationContext();
//        Session.init(sContext);
//        if (!Session.getInstance().hasAccount()) {
//            new initSession(sContext).execute();
//        }
    }

    public static Context getContext() {
        return sContext;
    }

    class initSession extends AsyncTask<Void, Void, Void> {
        Context mContext = null;

        initSession(Context context) {
            mContext = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
//            Session.getInstance().initAccount();
            return null;
        }
    }
}
