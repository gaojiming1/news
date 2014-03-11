package com.news.config;

import java.util.ArrayList;

public class DbTableConfig {
	
	public ArrayList<String> getTables() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("create table tb_nav (id integer primary key autoincrement, name varchar(20), type integer) ");
		return list;
	}
}
