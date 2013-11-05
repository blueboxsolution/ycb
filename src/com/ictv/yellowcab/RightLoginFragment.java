package com.ictv.yellowcab;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RightLoginFragment extends Fragment implements View.OnClickListener{
	
	private Handler mHandler = new Handler();
	Intent i = null;
	 @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.right_login_layout,
	        container, false);
	    Button loginBtn = (Button) view.findViewById(R.id.loginBtn);
	    loginBtn.setOnClickListener(new View.OnClickListener() {
	      @Override
	      public void onClick(View v) {
	    	  Intent intent = new Intent(getActivity(), LoginActivity.class);
	    	  startActivity(intent);
	      }
	    });
	    
	    Button registerBtn = (Button) view.findViewById(R.id.registerBtn);
	    registerBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), RegisterActivity.class);
		    	  startActivity(intent);
			}
		});
	    
	    
	    return view;
	  }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	


}
