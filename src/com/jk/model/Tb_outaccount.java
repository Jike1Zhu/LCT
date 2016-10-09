package com.jk.model;

public class Tb_outaccount// ֧����Ϣʵ����
{
    private int _id;// �洢֧�����
    private double money;// �洢֧�����
    private String time;// �洢֧��ʱ��
    private String type;// �洢֧�����
    private String address;// �洢֧���ص�
    private String mark;// �洢֧����ע

    public Tb_outaccount() {// Ĭ�Ϲ��캯��
        super();
    }

    // �����вι��캯����������ʼ��֧����Ϣʵ�����еĸ����ֶ�
    public Tb_outaccount(int id, double money, String time, String type, String address, String mark) {
        super();
        this._id = id;// Ϊ֧����Ÿ�ֵ
        this.money = money;// Ϊ֧����ֵ
        this.time = time;// Ϊ֧��ʱ�丳ֵ
        this.type = type;// Ϊ֧�����ֵ
        this.address = address;// Ϊ֧���ص㸳ֵ
        this.mark = mark;// Ϊ֧����ע��ֵ
    }

    public int getid() {// ����֧����ŵĿɶ�����
        return _id;
    }

    public void setid(int id) {// ����֧����ŵĿ�д����
        this._id = id;
    }

    public double getMoney() {// ����֧�����Ŀɶ�����
        return money;
    }

    public void setMoney(double money) {// ����֧�����Ŀ�д����
        this.money = money;
    }

    public String getTime() {// ����֧��ʱ��Ŀɶ�����
        return time;
    }

    public void setTime(String time) {// ����֧��ʱ��Ŀ�д����
        this.time = time;
    }

    public String getType() {// ����֧�����Ŀɶ�����
        return type;
    }

    public void setType(String type) {// ����֧�����Ŀ�д����
        this.type = type;
    }

    public String getAddress() {// ����֧���ص�Ŀɶ�����
        return address;
    }

    public void setAddress(String address) {// ����֧���ص�Ŀ�д����
        this.address = address;
    }

    public String getMark() {// ����֧����ע�Ŀɶ�����
        return mark;
    }

    public void setMark(String mark) {// ����֧����ע�Ŀ�д����
        this.mark = mark;
    }
}
