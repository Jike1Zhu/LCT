package com.jk.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jk.model.Tb_flag;

public class FlagDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public FlagDAO(Context context) {// 定义构造函数

        helper = new DBOpenHelper(context);// 初始化DBOpenHelper
    }

    /**
     * 添加
     * 
     * @param tb_flag
     */
    public void add(Tb_flag tb_flag) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into tb_flag (_id,flag) values (?,?)", new Object[] { tb_flag.getid(), tb_flag.getFlag() });
    }

    /**
     * 更新
     * 
     * @param tb_flag
     */
    public void update(Tb_flag tb_flag) {
        db = helper.getWritableDatabase();
        db.execSQL("update tb_flag set flag = ? where _id = ?", new Object[] { tb_flag.getFlag(), tb_flag.getid() });
    }

    /**
     * 查找信息
     * 
     * @param id
     * @return
     */
    public Tb_flag find(int id) {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select _id,flag from tb_flag where _id = ?", new String[] { String.valueOf(id) });
        if (cursor.moveToNext()) {

            
            return new Tb_flag(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("flag")));
        }
        return null;
    }

    /**
     * 删除
     * 
     * @param ids
     */
    public void detele(Integer... ids) {
        if (ids.length > 0) {// 判断id是否存存在

            StringBuffer sb = new StringBuffer();// 创建StringBuffer对象
            for (int i = 0; i < ids.length; i++) {// 遍历要删除的id集合

                sb.append('?').append(',');// 吧删除条件添加到StringBuffer对象中
            }
            sb.deleteCharAt(sb.length() - 1);// 去掉最后一个“，”逗号
            db = helper.getWritableDatabase();// 初始化SQLiteDatabase
            // 执行删除操作
            db.execSQL("delete from tb_flag where _id in (" + sb + ")", (Object[]) ids);
        }
    }

    public void deleteById(String id){
		//1. 得到连接
		db = helper.getWritableDatabase(); 
		//2. 执行delete delete from black_number where _id=id
		db.execSQL("delete from tb_flag where _id =" + id + "");
		//int deleteCount = database.delete("tb_outaccount", "_id=?", new String[]{id+""});
		//Log.i("TAG", "deleteCount="+deleteCount);
		//3. 关闭
		db.close();
	}
    /**
     * 
     * 
     * @param start
     *            起始位置
     * @param count
     *            每页显示的数量
     * @return
     */
    public List<Tb_flag> getScrollData(int start, int count) {
        List<Tb_flag> lisTb_flags = new ArrayList<Tb_flag>();// 创建集合对象
        db = helper.getWritableDatabase();// 初始化SQLiteDatabase
       
        Cursor cursor = db.rawQuery("select * from tb_flag limit ?,?", new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()) {

            
            lisTb_flags.add(new Tb_flag(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("flag"))));
        }
        return lisTb_flags;// 返回集合
    }

    /**
     * 查找表tb_flag的集合数量
     * 
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select count(_id) from tb_flag", null);
        if (cursor.moveToNext()) {

            return cursor.getLong(0);
        }
        return 0;
    }

    /**
     * 获得最大id
     * 
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(_id) from tb_flag", null);
        while (cursor.moveToLast()) {
            return cursor.getInt(0);
        }
        return 0;
    }
}
