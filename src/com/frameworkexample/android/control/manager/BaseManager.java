package com.frameworkexample.android.control.manager;

import org.ixming.android.utils.ToastUtils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

/**
 * Activity中，一些复杂的数据请求，逻辑运算等在此处进行，让Activity较为简单地进行界面的更新操作. <br/>
 * <br/>
 * 即Activity调用其相应的Manager类进行控制、动作相关的操作。
 * 
 * @author Yin Yong
 * @version 1.0
 */
public abstract class BaseManager {
	private Context appContext;
	private Handler handler;

	public BaseManager(Context context, Handler handler) {
		if (null == context) {
			throw new NullPointerException("context is null");
		}
		if (context instanceof Activity) {
			this.appContext = context.getApplicationContext();
		} else {
			this.appContext = context;
		}
		this.handler = handler;
	}

	protected final Context getApplicationContext() {
		return this.appContext;
	}

	protected final Handler getHandler() {
		return handler;
	}

	public final void toastShow(final String msg) {
		if (TextUtils.isEmpty(msg)) {
			return;
		}
		ToastUtils.showToast(appContext, handler, msg);
	}

	public final void toastShow(final int resId) {
		toastShow(appContext.getString(resId));
	}
}
