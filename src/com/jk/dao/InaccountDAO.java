package com.jk.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jk.model.Tb_inaccount;

public class InaccountDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public InaccountDAO(Context context) {

        helper = new DBOpenHelper(context);
    }

    /**
     *    Ϣ
     * 
     * @param tb_inaccount
     */
    public void add(Tb_inaccount tb_inaccount) {
        db = helper.getWritableDatabase();
        
        db.execSQL("insert into tb_inaccount (_id,money,time,type,handler,mark) values (?,?,?,?,?,?)",
                new Object[] { tb_inaccount.getid(), tb_inaccount.getMoney(), tb_inaccount.getTime(), tb_inaccount.getType(), tb_inaccount.getHandler(),
                        tb_inaccount.getMark() });
    }

    /**
     *     Ϣ
     * 
     * @param tb_inaccount
     */
    public void update(Tb_inaccount tb_inaccount) {
        db = helper.getWritableDatabase();
       
        db.execSQL("update tb_inaccount set money = ?,time = ?,type = ?,handler = ?,mark = ? where _id = ?", new Object[] { tb_inaccount.getMoney(),
                tb_inaccount.getTime(), tb_inaccount.getType(), tb_inaccount.getHandler(), tb_inaccount.getMark(), tb_inaccount.getid() });
    }

    public void deleteById(String id){
		//1. 得到连接
		db = helper.getWritableDatabase(); 
		//2. 执行delete delete from black_number where _id=id
		db.execSQL("delete from tb_inaccount where _id =" + id + "");
		//int deleteCount = database.delete("tb_outaccount", "_id=?", new String[]{id+""});
		//Log.i("TAG", "deleteCount="+deleteCount);
		//3. 关闭
		db.close();
	}
    /**
     *     Ϣ
     * 
     * @param id
     * @return
     */
    public Tb_inaccount find(int id) {
        db = helper.getWritableDatabase(); 
        Cursor cursor = db.rawQuery("select _id,money,time,type,handler,mark from tb_inaccount where _id = ?", new String[] { String.valueOf(id) });//    ݱ Ų   Ϣ  洢  Cursor 
        if (cursor.moveToNext()) {

            
            return new Tb_inaccount(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getDouble(cursor.getColumnIndex("money")), cursor.getString(cursor
                    .getColumnIndex("time")), cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("handler")),
                    cursor.getString(cursor.getColumnIndex("mark")));
        }
        return null;
    }

    /**
     *  h  Ϣ
     * 
     * @param ids
     */
    public void detele(Integer... ids) {
        if (ids.length > 0) {

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < ids.length; i++) {

                sb.append('?').append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            db = helper.getWritableDatabase();
           
            db.execSQL("delete from tb_inaccount where _id in (" + sb + ")", (Object[]) ids);
        }
    }

    /**
     *   ȡ   Ϣ
     * 
     * @param start
     *             
     * @param count
     *           
     * @return
     */
    public List<Tb_inaccount> getScrollData(int start, int count) {
        List<Tb_inaccount> tb_inaccount = new ArrayList<Tb_inaccount>();
        db = helper.getWritableDatabase();
       
        Cursor cursor = db.rawQuery("select * from tb_inaccount limit ?,?", new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()) {

            
            tb_inaccount.add(new Tb_inaccount(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getDouble(cursor.getColumnIndex("money")), cursor
                    .getString(cursor.getColumnIndex("time")), cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor
                    .getColumnIndex("handler")), cursor.getString(cursor.getColumnIndex("mark"))));
        }
        return tb_inaccount; 
    }

    /**
     *   ȡ ܼ ¼  
     * 
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select count(_id) from tb_inaccount", null);
        if (cursor.moveToNext()) {   

            return cursor.getLong(0);
        }
        return 0;
    }

    /**
     *   ȡ   
     * 
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(_id) from tb_inaccount", null);
        while (cursor.moveToLast()) {
            return cursor.getInt(0);
        }
        return 0;
    }
}
