package com.jk.model;

public class Tb_pwd// �������ݱ�ʵ����
{
    private String password;// �����ַ�������ʾ�û�����

    public Tb_pwd() {// Ĭ�Ϲ��캯��
        super();
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
}
