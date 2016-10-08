package com.jk.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Find_data {
	private SQLiteDatabase DB;
	private DBHelper helper;

	public  Find_data (Context context){
		helper = new DBHelper(context, null, 0);
	}
	/**
	 * 查找收入信息
	 * 
	 * @param id
	 * @return
	 */
	private Tb_inaccount find1(int id) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		Cursor cursor = DB
				.rawQuery(
						"select _id,money,ime,type,handler,handler,mark from tb_inaccount where _id=?",
						new String[] { String.valueOf(id) });
		if (cursor.moveToNext()) {
			return new Tb_inaccount((cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("handler")),
					cursor.getString(cursor.getColumnIndex("mark"))					
					);
		}
		return null;
	}
	
	/**
	 * 查找收入信息
	 * 
	 * @param id
	 * @return
	 */
	private Tb_outaccount find2(int id) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		Cursor cursor = DB
				.rawQuery(
						"select _id,money,time,type,mark from tb_outaccount where _id=?",
						new String[] { String.valueOf(id) });
		if (cursor.moveToNext()) {
			return new Tb_outaccount((cursor.getColumnIndex("_id")),
					cursor.getDouble(cursor.getColumnIndex("money")),
					cursor.getString(cursor.getColumnIndex("time")),
					cursor.getString(cursor.getColumnIndex("type")),
					cursor.getString(cursor.getColumnIndex("mark"))					
					);
		}
		return null;
	}
	/**
	 * 查找收入信息
	 * 
	 * @param Tb_pwd
	 */
	private void Tb_pwd (Tb_pwd tb_pwd) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("select pwd from tb_pwd",
				new Object[] { tb_pwd.getPwd()});
			
	}
	
	/**
	 * 查找便签信息
	 * 
	 * @param id
	 * @return
	 */
	private Tb_flag find3(int id) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		Cursor cursor = DB
				.rawQuery(
						"select flag Tb_flagfrom where _id=?",
						new String[] { String.valueOf(id) });
		if (cursor.moveToNext()) {
			return new Tb_flag((cursor.getColumnIndex("_id")),
					cursor.getString(cursor.getColumnIndex("flag"))			
					);
		}
		return null;
	}
}
