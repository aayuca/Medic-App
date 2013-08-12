package com.acem.medicapp.main;

import java.util.ArrayList;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.acem.medicapp.R;
import com.acem.medicapp.data.Hospital;

public class HospitalAdapter extends ArrayAdapter<Hospital> implements OnClickListener {

	private final Context context;
	private final ArrayList<Hospital> li;
	Typeface tf;

	public HospitalAdapter(Context context, ArrayList<Hospital> li) {
		super(context, R.layout.listrow_hospitalinfo, li);
		this.context = context;
		this.li = li;
		tf = Typeface.createFromAsset(context.getAssets(), "fonts/Antic.ttf");

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int index = position;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView1 = inflater.inflate(R.layout.listrow_hospitalinfo, parent, false);
		TextView name = (TextView) rowView1.findViewById(R.id.hi_name);

		TextView hospitalicon = (TextView) rowView1.findViewById(R.id.hi_hospitalicon);
		TextView description = (TextView) rowView1.findViewById(R.id.hi_description);
		description.setTypeface(tf);
		description.setLinksClickable(true);
		description.setAutoLinkMask(Linkify.ALL); // to open links
		TextView phoneno = (TextView) rowView1.findViewById(R.id.hi_phone);
		phoneno.setTypeface(tf);
		TextView gps = (TextView) rowView1.findViewById(R.id.hi_gps);
		gps.setTypeface(tf);
		TextView contact = (TextView) rowView1.findViewById(R.id.hi_contact);
		contact.setTypeface(tf);
		ImageButton call = (ImageButton) rowView1.findViewById(R.id.hi_call);
		call.setOnClickListener(this);
		ImageButton map = (ImageButton) rowView1.findViewById(R.id.hi_map);
		map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				openGoogleMap(li.get(index).getLatitude(), li.get(index).getLongitude(),
						li.get(index).getName() + "\n" + li.get(index).getDistrict() + "," + li.get(index).getStreet());
			}
		});

		// if (li.get(position).getStatus() == 0) {
		// status.setBackgroundColor(Color.GREEN);
		// } else if (li.get(position).getStatus() == 1) {
		// status.setBackgroundColor(Color.BLUE);
		// }else if(li.get(position).getStatus() == 2){
		// status.setBackgroundColor(Color.RED);
		// }

		hospitalicon.setText(li.get(position).getEstd());
		name.setText(li.get(position).getName());
		description.setText(li.get(position).getDescription());
		contact.setText(li.get(position).getDistrict() + ", " + li.get(position).getStreet());

		phoneno.setText("Phone No : " + li.get(position).getPhoneno());
		gps.setText("GPS : " + li.get(position).getLatitude() + "," + li.get(position).getLongitude());

		return rowView1;

		// TODO Auto-generated constructor stub
	}

	private void call() {
		try {
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9840065870"));
			callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(callIntent);
		} catch (ActivityNotFoundException e) {
			Log.e(HospitalAdapter.class.getName(), "Call failed", e);
		}
	}

	private void openGoogleMap(String latitude, String longitude, String address) {
		try {
			Intent mapIntent = new Intent(context, MapRoutes.class);
			mapIntent.putExtra("latitude", Double.parseDouble(latitude));
			mapIntent.putExtra("longitude", Double.parseDouble(longitude));
			mapIntent.putExtra("address", address);
			mapIntent.putExtra("flag", 1);
			mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(mapIntent);
		} catch (ActivityNotFoundException e) {
			Log.e(HospitalAdapter.class.getName(), "Map failed", e);
		}
	}

	@Override
	public void onClick(View source) {
		switch (source.getId()) {
		case R.id.hi_call:
			call();
			break;
		default:
			Log.d(HospitalAdapter.class.getName(), "ERROR e");
		}

	}
}
