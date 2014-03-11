package com.news.base;

import java.util.ArrayList;

import com.news.config.DbTableConfig;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbBase extends SQLiteOpenHelper {

	public DbBase(Context context) {
		super(context, "news_db.db", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		DbTableConfig dbTableConfig = new DbTableConfig();
		ArrayList<String> list = dbTableConfig.getTables();
		String table = null;
		for (int i = 0; i < list.size(); i++) {
			table = list.get(i);
			db.execSQL(table);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}

}
