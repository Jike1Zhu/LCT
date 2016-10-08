package com.jk.activity;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

import com.jk.DAO.Add_data;
import com.jk.DAO.Tb_outaccount;
import com.patrickstar.slidingmenudemo.R;

public class Bj_Xz_info extends Activity implements View.OnTouchListener {

	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private static final String[] m = { "A型", "B型", "O型", "AB型", "其他" };

	private EditText editdate;
	private Button zcbc;
	private EditText sj,je,bz;
	private Spinner lx;

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
		
		zcbc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Toast.makeText(Bj_Xz_info.this, "1123", Toast.LENGTH_LONG).show();*/
				Add_data  add_data  =new Add_data(Bj_Xz_info.this);
				Tb_outaccount outinfo = new Tb_outaccount();
				outinfo.setMoney(je.getText().toString());
				outinfo.setTime(sj.getText().toString());
				outinfo.setType(lx.getSelectedItem().toString());
				outinfo.setMark(bz.getText().toString());
				
				add_data.outadd(outinfo);
				
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
