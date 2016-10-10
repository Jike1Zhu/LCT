package com.jk.model;

public class Tb_pwd// �������ݱ�ʵ����
{
	

	private String password;// �����ַ�������ʾ�û�����
	private int id;
	private String da;

	public Tb_pwd() {// Ĭ�Ϲ��캯��
		super();
	}

	public Tb_pwd(int id,String da) {
		super();
		
		this.id = id;
		this.da = da;
	}
	

	public Tb_pwd(String password) {// �����вι��캯��
		super();
		this.password = password;// Ϊ���븳ֵ
		
	}

	public String getPassword() {// ��������Ŀɶ�����
		return password;
	}

	public void setPassword(String password) {// ��������Ŀ�д����
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}
}
