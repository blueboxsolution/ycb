package com.ictv.yellowcab;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StoreLocatorActivity extends BaseActivity {

	public StoreLocatorActivity() {
		super(R.string.header);
		// TODO Auto-generated constructor stub
		// super(R.string.header);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top_layout);
		getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		setContentView(R.layout.store_locator_layout);
		getSupportFragmentManager().beginTransaction()
		// .replace(R.id.content_frame, new SampleListFragment())
		.commit();

		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame_two, new RightMenuFragment()).commit();

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

		checkGPSOn();
	}

	public void showAlertDialog() {
		CustomDialogClass cdd = new CustomDialogClass(StoreLocatorActivity.this);
		cdd.show();
	}

	public void checkGPSOn() {
		final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			showAlertDialog();
		}
	}
}
