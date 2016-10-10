package com.jk.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jk.model.Tb_pwd;

public class PwdDAO {
    private DBOpenHelper helper;// ����DBOpenHelper����
    private SQLiteDatabase db;// ����SQLiteDatabase����

    public PwdDAO(Context context) {// ���幹�캯��

        helper = new DBOpenHelper(context);// ��ʼ��DBOpenHelper����
    }

    /**
     * ���������Ϣ
     * 
     * @param tb_pwd
     */
    public void add(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // ִ������������
        db.execSQL("insert into tb_pwd (password) values (?)", new Object[] { tb_pwd.getPassword() });
    }
    
    public void add_mb(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // ִ������������
        db.execSQL("insert into tb_pwd (mbid,mbda) values (?,?)", new Object[] { tb_pwd.getId() , tb_pwd.getDa() });
    }
    
    public int find_mb(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // �������벢�洢��Cursor����
        Cursor cursor = db.rawQuery("select * from tb_pwd where mbid =? and mbda =?",  new String[] { tb_pwd.getId()+"",tb_pwd.getDa() });
        if (cursor.moveToNext()) {// �������ҵ���������Ϣ
            // ������洢��Tb_pwd����
            return 1;
        }
        return 0;// ���û����Ϣ���򷵻�null
    }
    
    public int find_mbda(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // �������벢�洢��Cursor����
        Cursor cursor = db.rawQuery("select mbda from tb_pwd where mbid =? ",  new String[] { tb_pwd.getId()+"" });
        if (cursor.moveToNext()) {// �������ҵ���������Ϣ
            // ������洢��Tb_pwd����
            return 1;
        }
        return 0;// ���û����Ϣ���򷵻�null
    }

    /**
     * ����������Ϣ
     * 
     * @param tb_pwd
     */
    public void update(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // ִ���޸��������
        db.execSQL("update tb_pwd set password = ?", new Object[] { tb_pwd.getPassword() });
    }
    
    public void update_mb(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // ִ���޸��������
        db.execSQL("update tb_pwd set mbid = ? , mbda = ?", new Object[] { tb_pwd.getId() ,tb_pwd.getDa() });
    }

    /**
     * ����������Ϣ
     * 
     * @return
     */
    public int find(Tb_pwd tb_pwd) {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // �������벢�洢��Cursor����
        Cursor cursor = db.rawQuery("select * from tb_pwd where password =?",  new String[] { tb_pwd.getPassword() });
        if (cursor.moveToNext()) {// �������ҵ���������Ϣ
            // ������洢��Tb_pwd����
            return 1;//new Tb_pwd(cursor.getString(cursor.getColumnIndex("password")));
        }
        return 0;// ���û����Ϣ���򷵻�null
    }

    public long getCount() {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        Cursor cursor = db.rawQuery("select count(password) from tb_pwd", null);// ��ȡ������Ϣ�ļ�¼��
        if (cursor.moveToNext()) {// �ж�Cursor���Ƿ�������
            return cursor.getLong(0);// �����ܼ�¼��
        }
        return 0;// ���û�����ݣ��򷵻�0
    }
}
