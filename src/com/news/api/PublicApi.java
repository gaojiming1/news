package com.news.api;

import com.news.base.ApiBase;

abstract public class PublicApi extends ApiBase {
	/*public boolean checkAnonymous() {
	if (!Session.getInstance().hasLogin()) {
		// Session.getInstance().anonymousLogin();
		return false;
	}
	return true;
}

public boolean checkMe() {
	if (!Session.getInstance().hasLogin()) {
		Intent intent = new Intent();
		intent.setClass(mManager.getContext(), LoginActivity.class);
		mManager.getContext().startActivity(intent);
		return false;
	}
	return true;
}*/

}
