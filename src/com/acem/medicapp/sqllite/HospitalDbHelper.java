package com.acem.medicapp.sqllite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HospitalDbHelper extends SQLiteOpenHelper {

	public static int VER = 3;
	Context context;

	public HospitalDbHelper(Context context) {
		super(context, "medicapp", null, VER);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite
	 * .SQLiteDatabase answers -id question_id answer ans_id form-user -user_id
	 * form_id status forms -id name description form_start_date form_endate
	 * author form_ques -form_id ques_id status questions -id ques type ques_id
	 * ans1 ans2 ans3 ans4 ans5 ques_ans -ques_id,correct ans user -id username
	 * password telephone email c_fname c_lname
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {

		String createForms = "create table hospital(_id integer primary key, name text,description text, beds integer,	emergency text,	district text, street text, longitude text,latitude text, phoneno text,estd text)";
		try {
			db.execSQL(createForms);
		} catch (SQLException sl) {
			sl.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		String deleteForms = "drop table if exist hospital";
		try {
			db.execSQL(deleteForms);
			onCreate(db);
		} catch (SQLException sl) {
			sl.printStackTrace();
		}

	}

}
