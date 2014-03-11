package com.news.database;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.news.base.DbBase;
import com.news.config.DbConfig;
import com.news.database.model.DbNavModel;

public class DbNav {
	
	DbBase dbBase = null;
	
	public DbNav(Context context) {
		dbBase = new DbBase(context);
	}
	
	/**
	 * 获取导航
	 * @return 返回导航数组
	 */
	public String[] getNav() {
		String[] nav = new String[]	{"test1", "test2", "test3", "test4", "test5", "test6", "test7"};
		List<DbNavModel> allNav = getAllNav();
		List<DbNavModel> use = use(allNav);
		if (use != null) {
			int number = use.size();
			nav = new String[number];
			for (int i = 0; i < number; i++) {
				nav[i] = use.get(i).getName();
			}
		}
		return nav;
	}
	
	public List<DbNavModel> use(List<DbNavModel> list) {
		List<DbNavModel> use = new ArrayList<DbNavModel>();
		if ( list == null ) {
			return null;
		}
		for (DbNavModel dbNavModel : list) {
			if (dbNavModel.getType() == DbConfig.NAV_TYPE_USE) {
				use.add(dbNavModel);
			}
		}
		return use;
	}
	
	public  List<DbNavModel> getAllNav() {
		SQLiteDatabase db = dbBase.getReadableDatabase();
		List<DbNavModel> list = new ArrayList<DbNavModel>();
		if (db.isOpen()) {
			Cursor cursor;
			cursor = db.query("tb_nav", null, null, null, null, null, null);
			while (cursor.moveToNext()) {
				DbNavModel nav = new DbNavModel();
				nav.setId(cursor.getInt(cursor.getColumnIndex("id")));
				nav.setName(cursor.getString(cursor.getColumnIndex("name")));
				nav.setType(cursor.getInt(cursor.getColumnIndex("type")));
				list.add(nav);
			}
			cursor.close();
			db.close();
			return list;
		}
		return null;
	}
}
