package com.jk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jk.dao.PwdDAO;
import com.jk.model.Tb_pwd;
import com.patrickstar.slidingmenudemo.R;

public class Mbwt_activity extends Activity{

	private Button mb_tj;
	private EditText mb_da;
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private static final String[] m = { "你第一次看的电影名称？", "你理想的工作？", "你最向往的城市？"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mbwt);
		
		spinner = (Spinner) findViewById(R.id.mbwt);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, m);

		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 将adapter 添加到spinner中
		spinner.setAdapter(adapter);

		// 添加事件Spinner事件监听
		// spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

		// 设置默认值
		spinner.setVisibility(View.VISIBLE);
		mb_tj = (Button) findViewById(R.id.mb_tj);
		mb_da = (EditText) findViewById(R.id.mbda);
		
		mb_tj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO objPwdDAO = new PwdDAO(Mbwt_activity.this);
				Tb_pwd objPwd = new Tb_pwd((int) spinner.getSelectedItemId(),mb_da.getText().toString());
				if(objPwdDAO.find_mb(objPwd) == 1){
					Toast.makeText(Mbwt_activity.this, "认证成功！", Toast.LENGTH_LONG).show();
					Intent objIntent = new Intent(Mbwt_activity.this,xgmm_activity.class);
					startActivity(objIntent);
				}
				finish();
			}
		});
		
		
		
	}

}
