package com.jk.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Update_data {
	private SQLiteDatabase DB;
	private DBHelper helper;

	public  Update_data (Context context){
		helper = new DBHelper(context, null, 0);
	}
	/**
	 * 修改收入信息
	 * 
	 * @param tb_inaccount
	 */
	private void inupdate(Tb_inaccount tb_inaccount) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("update tb_inaccount set money=?," +
											"time=?," + 
											"type=?,"+ 
											"handler=?," + 
											"mark=? " + 
											"where _id=?",
				new Object[] { tb_inaccount.getMoney(), 
								tb_inaccount.getTime(),
								tb_inaccount.getType(), 
								tb_inaccount.getHandler(),
								tb_inaccount.getMark() });
		}
	/**
	 * 修改支出信息
	 * 
	 * @param tb_outaccount
	 */
	private void outupdate(Tb_outaccount tb_outaccount) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("update tb_outaccount set money=?," + 
											"time=?," +
											"type=?,"+
											"mark=? " +
											"where _id=?",
				new Object[] {  tb_outaccount.getMoney(),
								tb_outaccount.getTime(), 
								tb_outaccount.getType(),
								tb_outaccount.getMark() });
		}
	/**
	 * 修改密码信息
	 * 
	 * @param tb_pwd
	 */
	private void pwdadd(Tb_pwd tb_pwd) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("update tb_pwd set pwd=?",
				new Object[] { tb_pwd.getPwd()});
			}
	/**
	 * 修改便签信息
	 * 
	 * @param tb_flag
	 */
	private void flagadd(Tb_flag tb_flag) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("update tb_flag set flag=? where _id=?",
				new Object[] { tb_flag.get_id(),
								tb_flag.getFlag()});
			}

}
