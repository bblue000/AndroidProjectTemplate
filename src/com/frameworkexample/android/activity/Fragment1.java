package com.frameworkexample.android.activity;

import org.ixming.android.inject.InjectorUtils;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.frameworkexample.android.R;
import com.frameworkexample.android.activity.base.BaseFragment;

public class Fragment1 extends BaseFragment {

	@Override
	public int provideLayoutResId() {
		return R.layout.activity_main;
	}

	@Override
	public void initView(View view) {
		view.setBackgroundColor(0xFFFFFF00);
	}

	@Override
	public void initListener() {
	}

	@Override
	public void initData(View view, Bundle savedInstanceState) {
		InjectorUtils.defaultInstance().inject(this, getRootView());
	}
	
	@Override
	protected Handler provideActivityHandler() {

		return null;
	}

	@Override
	public void onClick(View v) {
	}

}
