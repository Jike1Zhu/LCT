package com.jk.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jk.activity.ZcFragement.MyAdapter;
import com.jk.dao.FlagDAO;
import com.jk.dao.OutaccountDAO;
import com.jk.model.Tb_flag;
import com.patrickstar.slidingmenudemo.R;

public class BqFragement extends Fragment {

	private Button qk,bc,ck;
	private View mView;
	private EditText et;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (mView == null) {
			initView(inflater, container);
		}
		return mView;
	}
	
	private void initView(LayoutInflater inflater, ViewGroup container) {
		mView = inflater.inflate(R.layout.bq, container, false);
		
		
		  qk = (Button) mView.findViewById(R.id.qk);
		  bc = (Button) mView.findViewById(R.id.bc);
		  ck = (Button) mView.findViewById(R.id.ck);
		  et = (EditText) mView.findViewById(R.id.et_bq);
		  
		  qk.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					et.setText("");
					
				}
			});
		  
		  bc.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					FlagDAO objFlagDAO =new FlagDAO(getActivity());
					String str = et.getText().toString();
					if(!str.isEmpty()){
						Tb_flag tb_flag = new  Tb_flag(objFlagDAO.getMaxId()+1,str);
						objFlagDAO.add(tb_flag);
						Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_LONG).show();
					}else {
						Toast.makeText(getActivity(), "内容为空", Toast.LENGTH_LONG).show();
					}
				
				}
			});
		  ck.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
				
				}
			});
		
		
	}
}
