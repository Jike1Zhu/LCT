package com.jk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jk.dao.PwdDAO;
import com.jk.model.Tb_pwd;
import com.patrickstar.slidingmenudemo.R;

public class Login_activity extends Activity{

	private Button btn_login;
	private EditText pwd;
	private TextView zhmm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		btn_login = (Button) findViewById(R.id.login);
		pwd = (EditText) findViewById(R.id.pwd);
		zhmm = (TextView) findViewById(R.id.zhmm);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO objPwdDAO = new PwdDAO(Login_activity.this);
				Tb_pwd objPwd = new Tb_pwd(pwd.getText().toString());
				if(objPwdDAO.find(objPwd) == 1){
					Toast.makeText(Login_activity.this, "登陆成功！", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(Login_activity.this, MainActivity.class);
					startActivity(intent);
					finish();
				}else{
					Toast.makeText(Login_activity.this, "密码不正确！", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		zhmm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login_activity.this, Mbwt_activity.class);
				startActivity(intent);
			}
		});
		
	}

}
