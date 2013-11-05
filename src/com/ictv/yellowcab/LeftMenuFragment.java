package com.ictv.yellowcab;

import org.apache.http.cookie.SM;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class LeftMenuFragment extends ListFragment {
	
	private Handler mHandler = new Handler();
	Intent i = null;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
		
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
//		for (int i = 0; i < 5; i++) {
			adapter.add(new SampleItem("Yellow Cab", android.R.drawable.ic_menu_search));
			adapter.add(new SampleItem("Home", R.drawable.menu_home_icon));
			adapter.add(new SampleItem("Store Locator", R.drawable.menu_store_locator_icon));
			adapter.add(new SampleItem("Store Menu", R.drawable.menu_store_icon));
			adapter.add(new SampleItem("Call for Delivery", R.drawable.menu_delivery_icon));
			adapter.add(new SampleItem("Feedback", R.drawable.menu_feedback_icon));
			adapter.add(new SampleItem("Settings", R.drawable.menu_settings_icon));
			
//		}
		setListAdapter(adapter);
		
		

		 
	
	}
	
	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		
		((SlidingFragmentActivity) getActivity()).getSlidingMenu().toggle();
		switch (position) {
		case 0:
			i = new Intent(getActivity().getApplicationContext(), TopActivity.class);
			break;
		case 1:
			i = new Intent(getActivity().getApplicationContext(), StoreLocatorActivity.class);
			break;
		default:
			break;
		}
		 mHandler.postDelayed(mUpdateTimeTask, 200);

	}
	
	private Runnable mUpdateTimeTask = new Runnable() {
		   public void run() {
		       // do what you need to do here after the delay
			   i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			    startActivity(i);
		   }
		};

	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}
		
		

	

	}
}
