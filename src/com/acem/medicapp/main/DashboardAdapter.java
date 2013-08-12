/*
 * Copyright (C) 2011 Patrik kerfeldt
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acem.medicapp.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.acem.medicapp.R;
import com.acem.medicapp.androidim.Login;

public class DashboardAdapter extends BaseAdapter implements OnClickListener {

	private final LayoutInflater mInflater;
	private static final int[] layoutID = { R.layout.dashboard1, R.layout.dashboard2 };

	Context context;
	Button bProfile, bOnlineDoc, bGraphView, bHospitalInfo, bHelpMe, vMap;

	public DashboardAdapter(Context context) {
		this.context = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return layoutID.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(layoutID[position], null);
		}
		loadDashboard(position, convertView);
		return convertView;
	}

	public void loadDashboard(int position, View convertView) {
		if (position == 0) {
			bProfile = (Button) convertView.findViewById(R.id.db_b_profile);
			bProfile.setOnClickListener(this);

			bHelpMe = (Button) convertView.findViewById(R.id.db_b_help);
			bHelpMe.setOnClickListener(this);

			bOnlineDoc = (Button) convertView.findViewById(R.id.db_b_onlinedoc);
			bOnlineDoc.setOnClickListener(this);

			bHospitalInfo = (Button) convertView.findViewById(R.id.db_b_hospitalinfo);
			bHospitalInfo.setOnClickListener(this);

			bGraphView = (Button) convertView.findViewById(R.id.db_b_graphview);
			bGraphView.setOnClickListener(this);
		} else if (position == 1) {
			vMap = (Button) convertView.findViewById(R.id.db_b_map);
			vMap.setOnClickListener(this);
		}

	}

	@Override
	public void onClick(View view) {
		Intent intent = null;
		switch (view.getId()) {

		case R.id.db_b_profile:
			intent = new Intent(context, Profile.class);
			break;
		case R.id.db_b_help:
			intent = new Intent(context, HelpMe.class);
			break;
		case R.id.db_b_hospitalinfo:
			intent = new Intent(context, Hospitals.class);
			break;
		case R.id.db_b_onlinedoc:
			intent = new Intent(context, Login.class);
			break;
		case R.id.db_b_graphview:
			intent = new Intent(context, AdvancedGraph.class);
			intent.putExtra("type", "line");
			// intent.putExtra("type", "bar");
			break;
		case R.id.db_b_map:
			intent = new Intent(context, MapRoutes.class);
			intent.putExtra("flag", 2);
			intent.putExtra("latitude", Double.parseDouble("1.234567"));
			intent.putExtra("longitude", Double.parseDouble("1.234567"));
			break;

		default:
			Toast.makeText(context, "Default Case!", Toast.LENGTH_SHORT).show();
		}
		if (intent != null) {
			context.startActivity(intent);
		}

	}

}
