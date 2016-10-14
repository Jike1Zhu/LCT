package com.jk.activity;


import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.jk.Fragement.ZcFragement;
import com.jk.ZDYImgview.CustomDialog;
import com.jk.model.Tb_outaccount;
import com.patrickstar.slidingmenudemo.R;

public class alertdialog_activity extends Activity{

	protected List<Tb_outaccount> data1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_normal_layout);
		showAlertDialog();
	}

	
	public void showAlertDialog() {

		CustomDialog.Builder builder = new CustomDialog.Builder(this);
		builder.setMessage("这个就是自定义的提示框");
		builder.setTitle("提示");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				//OutaccountDAO outinfo = new OutaccountDAO(alertdialog_activity.this);
				//data1 = outinfo.getScrollData(0, (int) outinfo.getCount());
				//Tb_outaccount tb_outaccount = data1.get(position1);
				//Intent intent = getIntent();
				Intent intent = getIntent();
				
				Toast.makeText(alertdialog_activity.this,intent.getStringExtra("op") , 100).show();
				Intent objIntent = new Intent(alertdialog_activity.this,ZcFragement.class);
				//startActivity(objIntent);
				//Toast.makeText(alertdialog_activity.this,intent.getStringExtra("position1") , 100).show();
				//outinfo.deleteById(tb_outaccount.getid() +"");
				//finish();
				//设置你的操作事项
			}
		});

		builder.setNegativeButton("取消",
				new android.content.DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});

		builder.create().show();

	}
}
