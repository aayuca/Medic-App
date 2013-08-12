package com.acem.medicapp.main;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.acem.medicapp.R;
import com.acem.medicapp.data.DAO;
import com.acem.medicapp.data.Hospital;

public class Hospitals extends ListActivity {

	private DAO dao;
	LinearLayout progresslayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allhospitals);
		progresslayout = (LinearLayout) findViewById(R.id.progesslayout_ques);
		AsyncConnection as = new AsyncConnection();
		as.execute();

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Hospital d = (Hospital) getListAdapter().getItem(position);
		Toast.makeText(this, d.getName(), Toast.LENGTH_SHORT).show();
		// String Form_name = d.getName();
		// String Form_author = d.getName();
		// String Form_des = d.getDescription();
		// Integer form_i = d.getId();
		// String f = form_i.toString();
		// Intent start = new Intent(getApplicationContext(), StartForm.class);
		// start.putExtra("name", Form_name);
		// start.putExtra("des", Form_des);
		// start.putExtra("author", Form_author);
		// start.putExtra("stdate", Form_start_date);
		// start.putExtra("edate", Form_endate);
		// start.putExtra("id", f);
		// finish();
		// startActivity(start);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static void createDummyHospitalInfo(Context context) {
		DAO dao = new DAO(context);
		dao.truncateHospital();
		String[] name = { "B & B", "Bir Hospital", "Alka", "Teaching" };
		String[] description = { "http://bnb.com.np", "http://birhospital.com.np", "http://alkahospital.com.np",
				"http://teachinghospital.com" };
		int[] beds = { 1, 2, 3, 4 };
		String[] district = { "Patan", "Kathmandu", "Patan", "Kathmandu" };
		String[] street = { "Gwarko", "Tedukehl", "Pulchowk", "Maharajgunj" };
		String[] latitude = { "1234.56", "1234.56", "27.673191", "1234.56" };
		String[] longitude = { "1234.56", "1234.56", "85.310013", "1234.56" };
		String[] phoneno = { "1234567", "2345678", "3456789", "3456789" };
		String[] estd = { "2001 A.D.", "1980 A.D.", "1997 A.D.", "1998 A.D." };

		for (int i = 0; i < name.length; i++) {
			dao.saveHospitalInfo(name[i], description[i], beds[i], "Y", district[i], street[i], latitude[i], longitude[i],
					phoneno[i], estd[i]);
		}
		dao.close();
	}

	private class AsyncConnection extends AsyncTask<Void, Void, Void> {
		ArrayList<Hospital> hospital = new ArrayList<Hospital>();

		@Override
		protected void onPreExecute() {
			progresslayout.setVisibility(View.VISIBLE);
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Hospitals.createDummyHospitalInfo(getApplicationContext());
			dao = new DAO(getApplicationContext());
			hospital = dao.getHospitalInfo();
			dao.close();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			progresslayout.setVisibility(View.GONE);
			Context aContext;
			aContext = getApplicationContext();
			setListAdapter(new HospitalAdapter(getApplicationContext(), hospital));

		}
	}

}
