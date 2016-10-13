package com.jk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jk.dao.PwdDAO;
import com.jk.model.Tb_pwd;
import com.patrickstar.slidingmenudemo.R;

public class xgmm_activity extends Activity{

	private Button mm_bc;
	private EditText mm_xmm,mm_qrmm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xgmm);
		mm_bc = (Button) findViewById(R.id.mm_bc);
		mm_xmm = (EditText) findViewById(R.id.et_xmm);
		mm_qrmm = (EditText) findViewById(R.id.et_qrmm);
		
		mm_bc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				PwdDAO objPwdDAO = new PwdDAO(xgmm_activity.this);
				if (mm_xmm.getText().toString().equals(mm_qrmm.getText().toString())) {
					Tb_pwd objtb_pwd = new Tb_pwd(mm_xmm.getText().toString());
					objPwdDAO.update(objtb_pwd);
					Toast.makeText(xgmm_activity.this, "修改成功！", Toast.LENGTH_LONG).show();
					finish();
				}else{
					Toast.makeText(xgmm_activity.this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
				}
				
				
			}
		});
		
	}
}
