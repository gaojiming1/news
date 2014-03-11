package com.news.config;

public class UrlConfig {
	// category db data
	public static final String NEWS_CATEGORY_RECOMMEND;

	// api url address
	public static final String API_HOST_NAME;

	// is online url address
	static {
	    if (FeatureConfig.ONLINE_SERVER) {
	        NEWS_CATEGORY_RECOMMEND = "online_url";
	        API_HOST_NAME = "api.bitjin.net";
	    } else {
	        NEWS_CATEGORY_RECOMMEND = "debug_url";
	        API_HOST_NAME = "api.bitjin.dev";
	    }
	}
}
