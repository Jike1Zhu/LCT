package com.jk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.jk.dao.PwdDAO;
import com.jk.model.Tb_pwd;
import com.patrickstar.slidingmenudemo.R;

public class Login_activity extends Activity{

	private Button btn_login;
	private EditText pwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		btn_login = (Button) findViewById(R.id.login);
		pwd = (EditText) findViewById(R.id.pwd);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO objPwdDAO = new PwdDAO(Login_activity.this);
				Tb_pwd objPwd = new Tb_pwd(pwd.getText().toString());
				//objPwdDAO.find(objPwd);
			}
		});
		
	}

}
