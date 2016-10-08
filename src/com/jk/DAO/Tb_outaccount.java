package com.jk.DAO;

public class Tb_outaccount {
	 private	 int _id ;
	 private String money;
	 private String time;
	 private String type;
	 private String mark;
	public  Tb_outaccount(int id,String money,String time,String type,String mark) {
		this._id = id;
		this.money = money;
		this.time  = time;
		this.type =type;
		this.mark =mark;
	}
	
	public  Tb_outaccount() {
		
	}



	public int getid() {
		return _id;
	}



	public void setid(int id) {
		this._id = id;
	}



	public String getMoney() {
		return money;
	}



	public void setMoney(String money) {
		this.money = money;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getMark() {
		return mark;
	}



	public void setMark(String mark) {
		this.mark = mark;
	}
}
