package com.jk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jk.dao.FlagDAO;
import com.jk.model.Tb_flag;
import com.patrickstar.slidingmenudemo.R;

public class bq_content_activity extends Activity {

	private EditText et_bqcontent;
	private Button bq_bc, bq_qk;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bq);
		et_bqcontent = (EditText) findViewById(R.id.et_bq);
		bq_bc = (Button) findViewById(R.id.bc);
		bq_qk = (Button) findViewById(R.id.qk);
		/*
		 * bj_Sr.finish(); bj_zc.finish(); bj_bq.finish(); xz_sr.finish();
		 * xz_zc.finish();
		 */

		bq_bc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				FlagDAO objFlagDAO = new FlagDAO(bq_content_activity.this);
				String str = et_bqcontent.getText().toString();
				if (!str.isEmpty()) {
					Tb_flag tb_flag = new Tb_flag(objFlagDAO.getMaxId() + 1,
							str);
					objFlagDAO.add(tb_flag);
					Toast.makeText(bq_content_activity.this, "保存成功",
							Toast.LENGTH_LONG).show();

					finish();
					
				} else {
					Toast.makeText(bq_content_activity.this, "内容为空",
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

}
