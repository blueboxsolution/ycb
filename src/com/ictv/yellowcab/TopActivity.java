package com.ictv.yellowcab;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TopActivity extends BaseActivity {

	
	
	public TopActivity() {
		super(R.string.header);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		setContentView(R.layout.top_layout);
		getSupportFragmentManager().beginTransaction();
//		.replace(R.id.content_frame, new RightMenuFragment())
//				.commit();

		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame_two, new RightMenuFragment()).commit();

		// setSlide();

		Button leftBtn = (Button) findViewById(R.id.button1);

		leftBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sm.setMode(SlidingMenu.LEFT_RIGHT);
				toggle();
			}
		});

		Button righBtn = (Button) findViewById(R.id.button2);

		righBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sm.setMode(SlidingMenu.RIGHT);
				sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				toggle();
				sm.setMode(SlidingMenu.LEFT_RIGHT);
				sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			}
		});

	}


//	public void showLocationGPS(){
//		startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
//	}

}
