package com.jk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jk.Fragement.MainActivity;
import com.jk.dao.FlagDAO;
import com.jk.model.Tb_flag;
import com.patrickstar.slidingmenudemo.R;

public class bq_bj_content_activity extends Activity {

	private EditText et_bqcontent;
	private Button bq_bc, bq_qk;
	private int id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bq);

		et_bqcontent = (EditText) findViewById(R.id.et_bq);
		bq_bc = (Button) findViewById(R.id.bc);
		bq_qk = (Button) findViewById(R.id.qk);
		Intent intent = getIntent();
		et_bqcontent.setText(intent.getStringExtra("Flag"));
		id = Integer.parseInt(intent.getStringExtra("id"));

		bq_bc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				FlagDAO objFlagDAO = new FlagDAO(bq_bj_content_activity.this);
				String str = et_bqcontent.getText().toString();
				if (!str.isEmpty()) {
					Tb_flag tb_flag = new Tb_flag(id, str);
					objFlagDAO.update(tb_flag);
					Toast.makeText(bq_bj_content_activity.this, "修改成功",
							Toast.LENGTH_LONG).show();

					finish();

				} else {
					Toast.makeText(bq_bj_content_activity.this, "内容为空",
							Toast.LENGTH_LONG).show();
				}

			}
		});

		bq_qk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				et_bqcontent.setText("");
			}
		});

	}

	@Override
	protected void onPause() {
		super.onPause();
		ActivityManager.getActivityManager().pushActivity(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		ActivityManager.getActivityManager().popActivity(this);
	}

}
