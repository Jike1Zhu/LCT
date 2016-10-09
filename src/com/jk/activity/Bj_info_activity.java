package com.jk.activity;

import java.util.Calendar;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.jk.dao.OutaccountDAO;
import com.jk.model.Tb_outaccount;
import com.patrickstar.slidingmenudemo.R;

public class Bj_info_activity extends Activity implements View.OnTouchListener {

	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private static final String[] m = { "还信用卡", "生活开支", "娱乐活动", "送礼", "其他" };

	private EditText editdate;
	private Button zcbc;
	private EditText sj, je, bz;
	private Spinner lx;
	private int id;
	private String op;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bj_info);
		spinner = (Spinner) findViewById(R.id.Spinner01);
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

		editdate = (EditText) this.findViewById(R.id.et_rqsj);
		editdate.setOnTouchListener(this);
		zcbc = (Button) findViewById(R.id.bc);
		je = (EditText) findViewById(R.id.edit_srje);
		sj = (EditText) findViewById(R.id.et_rqsj);
		bz = (EditText) findViewById(R.id.et_bz);
		lx = (Spinner) findViewById(R.id.Spinner01);

		Intent intent = getIntent();

		id = Integer.parseInt(intent.getStringExtra("id"));
		Toast.makeText(Bj_info_activity.this, "1111", Toast.LENGTH_LONG).show();
		je.setText(intent.getStringExtra("Money")); // Type
		sj.setText(intent.getStringExtra("Time"));
		bz.setText(intent.getStringExtra("Depict"));
		if (intent.getStringExtra("Type").equals("还信用卡")) {
			lx.setSelection(0, true);
		} else if (intent.getStringExtra("Type").equals("生活开支")) {
			lx.setSelection(1, true);
		} else if (intent.getStringExtra("Type").equals("娱乐活动")) {
			lx.setSelection(2, true);
		} else if (intent.getStringExtra("Type").equals("送礼")) {
			lx.setSelection(3, true);
		} else {
			lx.setSelection(4, true);
		}

		zcbc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String money = je.getText().toString();
				Intent objIntent = new Intent();
				objIntent.putExtra("Money", Double.parseDouble(money));
				objIntent.putExtra("Time", sj.getText().toString());
				objIntent.putExtra("Type", lx.getSelectedItem().toString());
				objIntent.putExtra("Depict", bz.getText().toString());

				Toast.makeText(Bj_info_activity.this, "我是编辑", Toast.LENGTH_LONG)
						.show();
				setResult(2, objIntent);

				finish();
			}

		});

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			View view = View.inflate(this, R.layout.dialog_data_time, null);
			final DatePicker datePicker = (DatePicker) view
					.findViewById(R.id.date_picker);
			final TimePicker timePicker = (android.widget.TimePicker) view
					.findViewById(R.id.time_picker);
			builder.setView(view);

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
					cal.get(Calendar.DAY_OF_MONTH), null);

			timePicker.setIs24HourView(true);
			timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
			timePicker.setCurrentMinute(Calendar.MINUTE);

			if (v.getId() == R.id.et_rqsj) {
				final int inType = editdate.getInputType();
				editdate.setInputType(InputType.TYPE_NULL);
				editdate.onTouchEvent(event);
				editdate.setInputType(inType);
				editdate.setSelection(editdate.getText().length());

				builder.setTitle("选取时间");
				builder.setPositiveButton("确  定",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								StringBuffer sb = new StringBuffer();
								sb.append(String.format("%d-%02d-%02d",
										datePicker.getYear(),
										datePicker.getMonth() + 1,
										datePicker.getDayOfMonth()));
								sb.append("  ");
								sb.append(timePicker.getCurrentHour())
										.append(":")
										.append(timePicker.getCurrentMinute());

								editdate.setText(sb);

								dialog.cancel();
							}
						});

			}

			Dialog dialog = builder.create();
			dialog.show();
		}

		return true;
	}

}
