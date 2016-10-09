package com.jk.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jk.model.Tb_outaccount;

public class OutaccountDAO {
    private DBOpenHelper helper;
    private SQLiteDatabase db;

    public OutaccountDAO(Context context) {

        helper = new DBOpenHelper(context);
    }

    /**
     *    ֧     
     * 
     * @param tb_outaccount
     */
    public void add(Tb_outaccount tb_outaccount) {
        db = helper.getWritableDatabase();
        // ִ     ֧         
        db.execSQL("insert into tb_outaccount (_id,money,time,type,address,mark) values (?,?,?,?,?,?)",
                new Object[] { tb_outaccount.getid(), tb_outaccount.getMoney(), tb_outaccount.getTime(), tb_outaccount.getType(), tb_outaccount.getAddress(),
                        tb_outaccount.getMark() });
        
        db.close();
    }

    /**
     *     ֧     
     * 
     * @param tb_outaccount
     */
    public void update(Tb_outaccount tb_outaccount) {
        db = helper.getWritableDatabase();
           
        db.execSQL("update tb_outaccount set money = ?,time = ?,type = ?,address = ?,mark = ? where _id = ?", new Object[] { tb_outaccount.getMoney(),
                tb_outaccount.getTime(), tb_outaccount.getType(), tb_outaccount.getAddress(), tb_outaccount.getMark(), tb_outaccount.getid() });
      
        db.close();
    }

    /**
     *     ֧     
     * 
     * @param id
     * @return
     */
    public Tb_outaccount find(int id) {
        db = helper.getWritableDatabase(); 
        Cursor cursor = db.rawQuery("select _id,money,time,type,address,mark from tb_outaccount where _id = ?", new String[] { String.valueOf(id) });//    ݱ Ų   ֧          洢  Cursor    
        if (cursor.moveToNext()) {

            
            return new Tb_outaccount(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getDouble(cursor.getColumnIndex("money")), cursor.getString(cursor
                    .getColumnIndex("time")), cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("address")),
                    cursor.getString(cursor.getColumnIndex("mark")));
        }
        cursor.close();
        db.close();
        return null;
        
    }

    /**
     *  h  ֧     
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
            // ִ  ɾ  ֧         
            db.execSQL("delete from tb_outaccount where _id in (" + sb + ")", (Object[]) ids);
        }
    }
    /**
	 * 删除单条数据
	 * @param id
	 */
	public void deleteById(String id){
		//1. 得到连接
		db = helper.getWritableDatabase(); 
		//2. 执行delete delete from black_number where _id=id
		db.execSQL("delete from tb_outaccount where _id =" + id + "");
		//int deleteCount = database.delete("tb_outaccount", "_id=?", new String[]{id+""});
		//Log.i("TAG", "deleteCount="+deleteCount);
		//3. 关闭
		db.close();
	}
    /**
     *    ֧     
     * 
     * @param start
     *              
     * @param count
     *           
     * @return
     */
    public List<Tb_outaccount> getScrollData(int start, int count) {
        List<Tb_outaccount> tb_outaccount = new ArrayList<Tb_outaccount>();
        db = helper.getWritableDatabase();
        //        ֧     
        Cursor cursor = db.rawQuery("select * from tb_outaccount limit ?,?", new String[] { String.valueOf(start), String.valueOf(count) });
        while (cursor.moveToNext()) {    

          
            tb_outaccount.add(new Tb_outaccount(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getDouble(cursor.getColumnIndex("money")), cursor
                    .getString(cursor.getColumnIndex("time")), cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor
                    .getColumnIndex("address")), cursor.getString(cursor.getColumnIndex("mark"))));
        }
        cursor.close();
        db.close();
        return tb_outaccount;
    }

    /**
     *     ܼ ¼  
     * 
     * @return
     */
    public long getCount() {
        db = helper.getWritableDatabase();  
        Cursor cursor = db.rawQuery("select count(_id) from tb_outaccount", null);
        if (cursor.moveToNext()) {

            return cursor.getLong(0);
        }
        cursor.close();
        db.close();
        return 0;            
    }

    /**
     *    ֧       
     * 
     * @return
     */
    public int getMaxId() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select max(_id) from tb_outaccount", null); 
        while (cursor.moveToLast()) {     
            return cursor.getInt(0);              
        }
        cursor.close();
        db.close();
        return 0;
    }
}
