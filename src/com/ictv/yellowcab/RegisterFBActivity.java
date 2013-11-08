package com.ictv.yellowcab;

import java.util.Arrays;
import java.util.List;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Request.GraphUserCallback;
import com.facebook.model.GraphUser;
import com.ictv.yellowcab.model.UserModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RegisterFBActivity extends Activity{
	TextView email = null;
	TextView password = null;
	TextView confirmPassword = null;
	TextView mobileNumber = null;
	private UserModel userModel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_fb_layout);
		email = (TextView) findViewById(R.id.email);
		password = (TextView) findViewById(R.id.password);
		confirmPassword= (TextView) findViewById(R.id.confirmPassword);
		mobileNumber = (TextView) findViewById(R.id.mobileNumber);
		userModel = new UserModel();
		 // start Facebook Login
	    Session.openActiveSession(this, true, new Session.StatusCallback() {
        // callback when session changes state
	    @Override
		public void call(Session session, SessionState state,
				Exception exception) {
			// TODO Auto-generated method stub
	    	if (session.isOpened()) {
	    		 List<String> PERMISSIONS = Arrays.asList("email");
	                if (!session.getPermissions().containsAll(PERMISSIONS)) {
	                    Session.NewPermissionsRequest newPermissionsRequest = new Session.NewPermissionsRequest(RegisterFBActivity.this,
	                            PERMISSIONS);
	                    session.requestNewReadPermissions(newPermissionsRequest);
	                }
	    		 // make request to the /me API
	    		Request request = Request.newMeRequest(session, new GraphUserCallback() {
	    			@Override
	    		    public void onCompleted(GraphUser user, Response response) {
	    		        System.out.println("USER ID :" + user.getId());
	    		        System.out.println("EMAIL :" + user.asMap().get("email"));
	    		      //  email.setText(user.asMap().get("email").toString());
	    		        userModel.setEmailStr(user.asMap().get("email").toString());
	    		    }
	    		});
	    		request.executeAsync();
	          }
		}
	    });
	    
	    Button registerBtn = (Button) findViewById(R.id.registerBtn);
	    registerBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("USER EMAIL : " + userModel.getEmailStr());
			}
		});
	}
	
	 @Override
	  public void onActivityResult(int requestCode, int resultCode, Intent data) {
	      super.onActivityResult(requestCode, resultCode, data);
	      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	      
	
	  }

}
