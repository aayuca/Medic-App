package acem.medicapp.main;

import acem.medicapp.R;
import acem.medicapp.androidim.Login;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends Activity implements OnClickListener {

	Button bOnlineDoc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		bOnlineDoc = (Button) findViewById(R.id.db_b_onlinedoc);
		bOnlineDoc.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.db_b_onlinedoc:
			startActivity(new Intent(this, Login.class));
			break;
		default:
			Toast.makeText(getApplicationContext(), "Default Case!", Toast.LENGTH_SHORT).show();
		}

	}

}
