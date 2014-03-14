package com.news.api;

public class Result {
	public static int STATE_OK = 0; // 正确的结果
	public static int STATE_UNKNOWN_ERROR = -1; // 未知的错误
	public static int STATE_NETWORK_STATE_ERROR = -2; // 网络状态错误
	public static int STATE_NETWORK_RW_ERROR = -3; // 网络读写错误
	public static int STATE_AUTHORIZATION_ERROR = -4; // 认证错误
	public static int STATE_PARSE_ERROR = -5; // 内容解析错误
	public static int STATE_CLIENT_ERROR = -6; // 客户端逻辑错误
	public int state = STATE_UNKNOWN_ERROR;
	public Object data;
	public String message;
}
