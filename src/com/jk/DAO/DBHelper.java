package com.jk.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context, String name,
			int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	//第一次建库时调用
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table tb_use (users varchar(20),pwd varchar(20))");
		db.execSQL("create table tb_inaccount" +
				"(_id integer primary key autoincrement, money decimal,time varchar(10),type varchar(10),handler varchar(100),mark varchar(200))");
		db.execSQL("create table tb_outaccount" +
				"(_id integer primary key autoincrement, money decimal,time varchar(10),type varchar(10),mark varchar(200))");
		db.execSQL("create table tb_flag(_id integer primary key autoincrement,flag varchar(200))");
	}
	@Override
	//更新版本
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
