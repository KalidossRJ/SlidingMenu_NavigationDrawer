package com.example.navigation_listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class ListAdapter extends BaseAdapter {

	Context context;
	String[] value;
	LayoutInflater inflater;

	public ListAdapter(Context context, String[] values) {
		this.context = context;
		this.value = values;
	}

	@Override
	public int getCount() {
		return value.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint("ViewHolder") 
	public View getView(int position, View convertView, ViewGroup parent) {

		TextView txtNearby;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflater.inflate(R.layout.list_item, parent, false);
		txtNearby = (TextView) itemView.findViewById(R.id.title);
		txtNearby.setText(value[position]);
		return itemView;
	}
}