package com.jk.model;

public class Tb_inaccount {// ������Ϣʵ����

    private int _id;// �洢������
    private double money;// �洢������
    private String time;// �洢����ʱ��
    private String type;// �洢�������
    private String handler;// �洢���븶�
    private String mark;// �洢���뱸ע

    public Tb_inaccount() {// Ĭ�Ϲ��캯��
        super();
    }

    // �����вι��캯����������ʼ��������Ϣʵ�����еĸ����ֶ�
    public Tb_inaccount(int id, double money, String time, String type, String handler, String mark) {
        super();
        this._id = id;// Ϊ�����Ÿ�ֵ
        this.money = money;// Ϊ�����ֵ
        this.time = time;// Ϊ����ʱ�丳ֵ
        this.type = type;// Ϊ�������ֵ
        this.handler = handler;// Ϊ���븶���ֵ
        this.mark = mark;// Ϊ���뱸ע��ֵ
    }

    public int getid() {// ���������ŵĿɶ�����
        return _id;
    }

    public void setid(int id) {// ���������ŵĿ�д����
        this._id = id;
    }

    public double getMoney() {// ����������Ŀɶ�����
        return money;
    }

    public void setMoney(double money) {// ����������Ŀ�д����
        this.money = money;
    }

    public String getTime() {// ��������ʱ��Ŀɶ�����
        return time;
    }

    public void setTime(String time) {// ��������ʱ��Ŀ�д����
        this.time = time;
    }

    public String getType() {// �����������Ŀɶ�����
        return type;
    }

    public void setType(String type) {// �����������Ŀ�д����
        this.type = type;
    }

    public String getHandler() {// �������븶��Ŀɶ�����
        return handler;
    }

    public void setHandler(String handler) {// �������븶��Ŀ�д����
        this.handler = handler;
    }

    public String getMark() {// �������뱸ע�Ŀɶ�����
        return mark;
    }

    public void setMark(String mark) {// �������뱸ע�Ŀ�д����
        this.mark = mark;
    }
}
