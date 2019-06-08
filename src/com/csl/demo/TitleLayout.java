package com.csl.demo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 自定义布局
 * @author Cherry
 * @date  2019年6月7日
 */
public class TitleLayout extends LinearLayout {

	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.title	, this);
		/*
		 * 定义布局中组件的相关事件
		 */
		Button btn = (Button) findViewById(R.id.A);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * 点击返回按钮
				 */
				((Activity) getContext()).finish();
			}
		});
	}

}
