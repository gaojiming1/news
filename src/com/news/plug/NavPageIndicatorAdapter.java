package com.news.plug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NavPageIndicatorAdapter extends FragmentPagerAdapter {

	public NavPageIndicatorAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int position) {
//		Fragment fragment = new ItemFragment();
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return super.getPageTitle(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
