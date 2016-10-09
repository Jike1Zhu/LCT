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

    /**
     * ����������Ϣ
     * 
     * @return
     */
    public Tb_pwd find() {
        db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
        // �������벢�洢��Cursor����
        Cursor cursor = db.rawQuery("select password from tb_pwd", null);
        if (cursor.moveToNext()) {// �������ҵ���������Ϣ
            // ������洢��Tb_pwd����
            return new Tb_pwd(cursor.getString(cursor.getColumnIndex("password")));
        }
        return null;// ���û����Ϣ���򷵻�null
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
