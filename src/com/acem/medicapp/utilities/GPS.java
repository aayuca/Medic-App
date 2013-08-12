package com.acem.medicapp.utilities;

import java.text.SimpleDateFormat;

import com.acem.medicapp.main.Splashscreen;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class GPS {
	Context context;

	public void getGPS(Context c) {
		context = c;
		Log.d(Splashscreen.class.getName(), "Entering to gps"); // JSONObject

		LocationManager ourManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
		ourManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 5, new LocationListener() {
			@Override
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

			}

			@Override
			public void onProviderEnabled(String arg0) {

			}

			@Override
			public void onProviderDisabled(String arg0) {

			}

			@Override
			public void onLocationChanged(Location loc) {
				SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd::hh:mm:ss");
				Log.d(GPS.class.getName(), loc.getLongitude() + ", " + loc.getLatitude());
				Toast.makeText(context, loc.getLongitude() + ", " + loc.getLatitude(), Toast.LENGTH_LONG).show();
			}
		});

	}

}
