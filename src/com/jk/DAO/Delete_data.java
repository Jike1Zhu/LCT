package com.jk.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Delete_data {
	private SQLiteDatabase DB;
	private DBHelper helper;

	public  Delete_data (Context context){
		helper = new DBHelper(context, null, 0);
	}
	/**
	 * 删除收入信息
	 * 
	 * @param ids
	 */
	private void indelete1(Integer... ids) {
		// TODO Auto-generated method stub
		if (ids.length > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ids.length; i++) {
				sb.append('?').append('?');
			}
			sb.deleteCharAt(sb.length() - 1);
			DB = helper.getWritableDatabase();
			DB.execSQL("delete for tb_inaccount where _id in (" + sb + ")",
					(Object[]) ids);
		}
		
	}

		/**
		 * 删除支出信息
		 * 
		 * @param ids
		 */
		private void indelete2(Integer... ids) {
			// TODO Auto-generated method stub
			if (ids.length > 0) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < ids.length; i++) {
					sb.append('?').append('?');
				}
				sb.deleteCharAt(sb.length() - 1);
				DB = helper.getWritableDatabase();
				DB.execSQL("delete for tb_outaccount where _id in (" + sb + ")",
						(Object[]) ids);
			}
		}
		
		/**
		 * 删除便签信息
		 * 
		 * @param ids
		 */
		private void indelete3(Integer... ids) {
			// TODO Auto-generated method stub
			if (ids.length > 0) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < ids.length; i++) {
					sb.append('?').append('?');
				}
				sb.deleteCharAt(sb.length() - 1);
				DB = helper.getWritableDatabase();
				DB.execSQL("delete for tb_flag where _id in (" + sb + ")",
						(Object[]) ids);
			}
		}
}
