package com.news.api;

public class RequestError {
	public static int ERROR_OK = 0; // 正确的结果
	public static int ERROR_UNKNOWN_ERROR = -1; // 未知的错误
	public static int ERROR_NETWORK_STATE_ERROR = -2; // 网络状态错误
	public static int ERROR_NETWORK_RW_ERROR = -3; // 网络读写错误
	public static int ERROR_AUTHORIZATION_ERROR = -4; // 认证错误
	public static int ERROR_PARSE_ERROR = -5; // 内容解析错误
	public static int ERROR_CLIENT_ERROR = -6; // 客户端逻辑错误
}
