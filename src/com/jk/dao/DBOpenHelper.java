package com.jk.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;// �������ݿ�汾��
    private static final String DBNAME = "account.db";// �������ݿ���

    public DBOpenHelper(Context context) {// ���幹�캯��

        super(context, DBNAME, null, VERSION);// ��д����Ĺ��캯��
    }

    @Override
    public void onCreate(SQLiteDatabase db) {// �������ݿ�
        db.execSQL("create table tb_outaccount (_id integer primary key,money decimal,time varchar(10),"
                + "type varchar(10),address varchar(100),mark varchar(200))");// ����֧����Ϣ��
        db.execSQL("create table tb_inaccount (_id integer primary key,money decimal,time varchar(10),"
                + "type varchar(10),handler varchar(100),mark varchar(200))");// ����������Ϣ��
        db.execSQL("create table tb_pwd (mbid integer,mbda varchar(100),password varchar(20))");// ���������
        db.execSQL("create table tb_flag (_id integer primary key,flag varchar(200))");// ������ǩ��Ϣ��
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {// ��д�����onUpgrade�������Ա����ݿ�汾����

    }
}
