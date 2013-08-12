package com.acem.medicapp.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.acem.medicapp.R;
import com.acem.medicapp.utilities.GPS;

public class HelpMe extends Activity implements OnClickListener {

	Button helpme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_me);
		helpme = (Button) findViewById(R.id.hm_askhelp);
		helpme.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help_me, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		GPS gps = new GPS();
		gps.getGPS(this);
	}

}
