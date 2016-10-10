package com.jk.Fragement;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jk.dao.PwdDAO;
import com.jk.model.Tb_pwd;
import com.patrickstar.slidingmenudemo.R;

public class XtszFragement extends Fragment {

	private View mView;
	private Button mb_tj;
	private EditText mb_da;
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private static final String[] m = { "你第一次看的电影名称？", "你理想的工作？", "你最向往的城市？"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (mView == null) {
			initView(inflater, container);
		}
		return mView;
		// return inflater.inflate(R.layout.zc,null);

	}

	private void initView(LayoutInflater inflater, ViewGroup container) {
		mView = inflater.inflate(R.layout.xtsz, container, false);
		spinner = (Spinner) mView.findViewById(R.id.mbwt);
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, m);

		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 将adapter 添加到spinner中
		spinner.setAdapter(adapter);

		// 添加事件Spinner事件监听
		// spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

		// 设置默认值
		spinner.setVisibility(View.VISIBLE);
		mb_tj = (Button) mView.findViewById(R.id.mb_bc);
		mb_da = (EditText) mView.findViewById(R.id.mbda);
		
		mb_tj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				PwdDAO objPwdDAO = new PwdDAO(getActivity());
				Tb_pwd tb_pwd = new Tb_pwd((int) spinner.getSelectedItemId(),mb_da.getText().toString());
				if(objPwdDAO.find_mbda(tb_pwd) == 1){
					objPwdDAO.update_mb(tb_pwd);
					Toast.makeText(getActivity(), "修改密保问题成功！", Toast.LENGTH_LONG).show();
				}else{
					objPwdDAO.add_mb(tb_pwd);
					Toast.makeText(getActivity(), "保存成功！", Toast.LENGTH_LONG).show();
				}
				
				
				
			}
		});

	}
}
