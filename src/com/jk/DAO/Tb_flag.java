package com.jk.DAO;

import android.content.Context;

public class Tb_flag {
	 private	 int _id ;
	 private String flag;
	 public Tb_flag(int id,String flag) {
		this._id=id;
		this.flag=flag;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int id) {
		this._id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
