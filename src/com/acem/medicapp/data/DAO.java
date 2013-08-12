package com.acem.medicapp.data;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.acem.medicapp.sqllite.HospitalDbHelper;

public class DAO {
	private final SQLiteDatabase db;

	private final HospitalDbHelper dbHelper;

	public DAO(Context context) {

		dbHelper = new HospitalDbHelper(context);
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		db.close();
	}

	public void truncateHospital() {
		db.rawQuery("delete from hospital", null);
	}

	public ArrayList<Hospital> getHospitalInfo() {
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
		Cursor cursor1 = db.rawQuery(
				"SELECT _id,name,description,beds,emergency,district,street,longitude,latitude,phoneno,estd FROM  hospital ",
				null);
		cursor1.moveToFirst();
		while (!cursor1.isAfterLast()) {
			Hospital aq = new Hospital(cursor1.getInt(0), cursor1.getString(1), cursor1.getString(2), cursor1.getInt(3),
					cursor1.getString(4), cursor1.getString(5), cursor1.getString(6), cursor1.getString(7), cursor1.getString(8),
					cursor1.getString(9), cursor1.getString(10));
			Log.d(DAO.class.getName(), cursor1.getString(2));
			hospitals.add(aq);
			cursor1.moveToNext();
		}
		db.close();
		return hospitals;

	}

	public void saveHospitalInfo(String name, String description, int beds, String emergency, String district, String street,
			String latitude, String longitude, String phoneno, String estd) {
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("description", description);
		values.put("beds", beds);
		values.put("emergency", emergency);
		values.put("district", district);
		values.put("street", street);
		values.put("longitude", longitude);
		values.put("latitude", latitude);
		values.put("phoneno", phoneno);
		values.put("estd", estd);
		db.insert("hospital", null, values);
	}

	/*
	 * public Userdata checkUser(String username, String password) { Userdata
	 * data = new Userdata(); // List<Userdata> userli = new
	 * ArrayList<Userdata>(); String[] columns = new String[] { "id", "username"
	 * }; Cursor cursor = db.query("user", columns, "username like" +
	 * "'username'", null, null, null, null); cursor.moveToFirst(); int count =
	 * cursor.getCount(); if (count != 1) {
	 * 
	 * data.set_ascesskey("sidelag"); return data; } else if (count == 1) {
	 * 
	 * while (!cursor.isAfterLast()) { if
	 * (password.matches(cursor.getString(2))) { data.set_id(cursor.getInt(0));
	 * data.setUsername(cursor.getString(1));
	 * data.setC_fname(cursor.getString(5));
	 * data.setC_lname(cursor.getString(6)); data.setEmail(cursor.getString(4));
	 * data.setTelephone(cursor.getInt(3)); data.set_ascesskey("ok"); //
	 * userli.add(data);
	 * 
	 * return data; }
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * data.set_ascesskey("sidelag"); // userli.add(data); return data; }
	 * data.set_ascesskey("sidelag"); // userli.add(data); return data; }
	 * 
	 * public int getMaxFormID() { int id = 0;
	 * 
	 * String query = "SELECT MAX(_id) AS max_id FROM forms"; Cursor cursor =
	 * db.rawQuery(query, null);
	 * 
	 * if (cursor.moveToFirst()) { do { id = cursor.getInt(0); } while
	 * (cursor.moveToNext()); } close(); return id;
	 * 
	 * }
	 * 
	 * public void saveUserAnswer(int index, String ans) { ContentValues values
	 * = new ContentValues(); values.put("userans", ans); db.update("questions",
	 * values, "ques_id=" + index, null); }
	 * 
	 * public void updateFormStatus(int formID, int status) { ContentValues
	 * values = new ContentValues(); values.put("status", status + "");
	 * Log.d(DAO
	 * .class.getName(),"Updating satatu form : "+formID+" status :"+status);
	 * db.update("forms", values, "_id=" + formID, null); }
	 */
}
