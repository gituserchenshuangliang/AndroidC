package com.csl.demo;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 创建水果类适配器，优化适配器.
 * @author Cherry
 * @date  2019年6月8日
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
	protected int rid;
	public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		/*
		 * 样式图层ID
		 */
		rid = textViewResourceId;
	}
	
	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*
		 * 获取类
		 */
		Fruit fruit = getItem(position);
		
		View v;
		
		ViewAcache viewAcache;
		if(null == convertView){
			/*
			 * 设置视图
			 */
			v = LayoutInflater.from(getContext()).inflate(rid, null);
			viewAcache = new ViewAcache();
			
			/*
			 * 实例组件
			 */
			viewAcache.imageView = (ImageView) v.findViewById(R.id.fruit_image);
			viewAcache.textView = (TextView) v.findViewById(R.id.fruit_name);
			/*
			 * 实例对象缓存到View中。
			 */
			v.setTag(viewAcache);
		}else{
			v = convertView;
			viewAcache = (ViewAcache) v.getTag();
		}
		
		/*
		 * 设置组件属性
		 */
		viewAcache.imageView.setImageResource(fruit.getImageId());
		viewAcache.textView.setText(fruit.getName());
		/*
		 * 返回View
		 */
		return v;
	}
	
	/*
	 * 图层缓存类
	 */
	class ViewAcache {
		ImageView imageView;
		TextView textView;
	}
}
