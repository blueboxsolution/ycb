package com.ictv.yellowcab;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.audiofx.BassBoost.Settings;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CustomDialogClass extends Dialog implements
		android.view.View.OnClickListener {
	public Activity c;
	public Dialog d;
	public Button yes, no;

	public CustomDialogClass(Activity a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.c = a;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.custom_dialog);
		yes = (Button) findViewById(R.id.button1);
		no = (Button) findViewById(R.id.button2);
		yes.setOnClickListener(this);
		no.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			showSettingGPS();
			break;
		case R.id.button2:
			dismiss();
			break;
		default:
			break;
		}
		dismiss();
	}

	public void showSettingGPS() {
		c.startActivityForResult(new Intent(
				android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
	}

}
