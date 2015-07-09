package com.javacodegeeks.android.slidingdrawertest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private SlidingDrawer drawer;
	private Button handle, clickMe;
	private TextView text1;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context = this.getApplicationContext();
		
		handle = (Button) findViewById(R.id.handle);
		text1 = (TextView) findViewById(R.id.text1);
		clickMe = (Button) findViewById(R.id.click);
		drawer=(SlidingDrawer)findViewById(R.id.slidingDrawer);
		
		drawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {
			@Override
			public void onDrawerOpened() {
				handle.setText("-");
				text1.setText("Already dragged...");
			}
		});
		
		drawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {
			
			@Override
			public void onDrawerClosed() {
				handle.setText("+");
				text1.setText("For more info drag the button...");
			}
		});
		
		clickMe.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "The button is clicked", Toast.LENGTH_LONG).show();
			}
		});
		
	}	

}

