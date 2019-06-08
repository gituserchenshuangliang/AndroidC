package com.csl.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * 主活动
 * @author Cherry
 * @date  2019年6月7日
 */
public class MainActivity extends BaseActivity {
	private List<Fruit> fruitList = new ArrayList<Fruit>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//listViewOne();
		//listViewTwo();
		showOne();
	}
	
	/*
	 * 简单的列表
	 */
	public void listViewOne(){
		String[] data = { "Apple", "Banana", "Orange", "Watermelon",
				"Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
		/*
		 * 通过适配器构建简单列表，可滑动屏幕。
		 * simple_list_item_single_choice 为样式。
		 */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_list_item_single_choice, data);
		ListView listView = (ListView) findViewById(R.id.A);
		listView.setAdapter(adapter);
	}
	
	/*
	 * 图文列表
	 */
	public void listViewTwo(){
		/*
		 * 初始化数据
		 */
		Fruit apple = new Fruit("Apple", R.drawable.a);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.b);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.c);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.d);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.e);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.g);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.f);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.h);
		fruitList.add(strawberry);
		/*
		 * 水果适配器
		 */
		FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
		/*
		 * 设置适配器
		 */
		ListView listView = (ListView) findViewById(R.id.A);
		listView.setAdapter(fruitAdapter);
		/*
		 * 添加点击事件。
		 */
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
				ab.setTitle("列表项");
				ab.setMessage(fruitList.get(position).getName());
				ab.setCancelable(false);
				
				ab.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});
				
				ab.setNegativeButton("取消",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});
				
				ab.show();
			}
		});
	}
	/*
	 * 获取屏幕密度值
	 */
	public void showOne(){
		float x = getResources().getDisplayMetrics().xdpi;
		float y = getResources().getDisplayMetrics().ydpi;
		Log.d(TAG,"屏幕X："+x);
		Log.d(TAG,"屏幕Y："+y);
	}
}
