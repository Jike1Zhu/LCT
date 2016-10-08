package com.jk.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Add_data {
	private SQLiteDatabase DB;
	private DBHelper helper;

	public  Add_data(Context context){
		helper = new DBHelper(context, "LCTDB", 0);
	}
	
	/**
	 * 添加收入信息
	 * 
	 * @param tb_inaccount
	 */
	public void inadd(Tb_inaccount tb_inaccount) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("insert into tb_inaccount (money," + 
											"time,"+
											"type," + 
											"handler," + 
											"mark) values (?,?,?,?,?,?)",
				new Object[] { 
								tb_inaccount.getMoney(),
								tb_inaccount.getTime(), 
								tb_inaccount.getType(),
								tb_inaccount.getHandler(),
								tb_inaccount.getMark() });
			}
	
	/**
	 * 添加支出信息
	 * 
	 * @param tb_outaccount
	 */
	public void outadd(Tb_outaccount tb_outaccount) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("insert into tb_outaccount (money," + 
											"time,"+ 
											"type," + 
											"mark) values (?,?,?,?)",
				new Object[] {
								tb_outaccount.getMoney(),
								tb_outaccount.getTime(), 
								tb_outaccount.getType(),
								tb_outaccount.getMark() });
	}
	
	/**
	 * 添加密码信息
	 * 
	 * @param tb_pwd
	 */
	public void pwdadd(Tb_pwd tb_pwd) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("insert into tb_pwd (pwd) values (?)",
				new Object[] { tb_pwd.getPwd()});
			}
	/**
	 * 添加便签信息
	 * 
	 * @param tb_flag
	 */
	public void flagadd(Tb_flag tb_flag) {
		// TODO Auto-generated method stub
		DB = helper.getWritableDatabase();
		DB.execSQL("insert into tb_flag (_id,flag) values (?,?)",
				new Object[] { tb_flag.get_id(),
								tb_flag.getFlag()});
			}
}
