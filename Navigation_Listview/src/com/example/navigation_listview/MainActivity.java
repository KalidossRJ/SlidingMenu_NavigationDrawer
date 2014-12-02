package com.example.navigation_listview;

import java.util.ArrayList;

import com.example.navigation_listview.utills.SlidingMenuLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends FragmentActivity {


	ListView Listview;
	static SlidingMenuLayout slidingmenu_layout;
	Context context;
	Button lk_profile_menu,lk_profile_filter_btn;
	ArrayList<String> values=new ArrayList<String>();
	String[] nearby_values={"Theaters","Restaurants","Cafe","ATM","Shopping Malls","Railway stations","Taxi stands","Gas_station","Banks","Hospitals","Pharmacy","Bar","Parks","Gym"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		slidingmenu_layout = (SlidingMenuLayout) this.getLayoutInflater().inflate(
				R.layout.activity_main, null);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(slidingmenu_layout);
		context=this;
		
		StartProfileActivity fragment = new StartProfileActivity();
		start_fragment(fragment);

		lk_profile_menu = (Button) findViewById(R.id.button_menu);
		lk_profile_menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Show/hide the menu
				Listview.smoothScrollToPosition(0);
				toggleMenu(v);
			}
		});
		Listview=(ListView)findViewById(R.id.list);
		Listview.setDividerHeight(2);
		Listview.setClickable(true);
		Listview.setBackgroundColor(Color.GRAY);
		ListAdapter adapter = new ListAdapter(context,nearby_values);
		Listview.setAdapter(adapter);
		
	}

	public static void toggleMenu(View v) {
		slidingmenu_layout.toggleMenu();
	}

	private void start_fragment(Fragment frag){
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		fragmentTransaction.replace(R.id.lk_profile_fragment, frag);
		fragmentTransaction.commit();
	}

}