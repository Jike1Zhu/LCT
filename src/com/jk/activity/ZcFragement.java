package com.jk.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.patrickstar.slidingmenudemo.R;

public class ZcFragement extends Fragment {

	private View mView;
	private ListView lv_show;
	private Button btn_tj;
	private List<Map<String, Object>> data;
	private TextView tv_rqsj;

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
		mView = inflater.inflate(R.layout.zc, container, false);
		lv_show = (ListView) mView.findViewById(R.id.lv_show);
		btn_tj = (Button) mView.findViewById(R.id.btn_tj);
		tv_rqsj = (TextView) mView.findViewById(R.id.tv_rqsj);
		btn_tj.setVisibility(1);
		data = getData();
		MyAdapter adapter = new MyAdapter(getActivity());
		lv_show.setAdapter(adapter);

		
		lv_show.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
			Intent intent = null;
			switch(arg2){
			case 0:
				intent = new Intent(getActivity(),Bj_Xz_info.class);
				startActivity(intent);
				break;
			}

			}
		});

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		/*
		 * tv1 = (TextView)getActivity().findViewById(R.id.tv1); btnShow =
		 * (Button)getActivity().findViewById(R.id.btn);
		 * btnShow.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { tv1.setText("hello");
		 * 
		 * }
		 */
		// lv_show.setAdapter(new
		// ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,
		// str));

	}

	// ViewHolder静态类
	static class ViewHolder {
		public TextView tv_type;
		public TextView tv_money;
		public TextView tv_data;
	}

	public class MyAdapter extends BaseAdapter {

		private LayoutInflater mInflater = null;

		private MyAdapter(Context context) {
			// 根据context上下文加载布局，这里的是Demo17Activity本身，即this
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// How many items are in the data set represented by this Adapter.
			// 在此适配器中所代表的数据集中的条目数
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// Get the data item associated with the specified position in the
			// data set.
			// 获取数据集中与指定索引对应的数据项
			return position;
		}

		@Override
		public long getItemId(int position) {
			// Get the row id associated with the specified position in the
			// list.
			// 获取在列表中与指定索引对应的行id
			return position;
		}

		// Get a View that displays the data at the specified position in the
		// data set.
		// 获取一个在数据集中指定索引的视图来显示数据
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			// 如果缓存convertView为空，则需要创建View
			if (convertView == null) {
				holder = new ViewHolder();
				// 根据自定义的Item布局加载布局
				convertView = mInflater.inflate(R.layout.list_item, null);
				holder.tv_type = (TextView) convertView
						.findViewById(R.id.tv_type);
				holder.tv_money = (TextView) convertView
						.findViewById(R.id.tv_money);
				holder.tv_data = (TextView) convertView
						.findViewById(R.id.tv_data);
				// 将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.tv_type.setText((String) data.get(position).get("type"));
			holder.tv_money.setText((String) data.get(position).get("money"));
			holder.tv_data.setText((String) data.get(position).get("data"));

			return convertView;
		}

	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		for (int i = 0; i < 10; i++) {
			map = new HashMap<String, Object>();
			map.put("type", "类型");
			map.put("money", "钱");
			map.put("data", "时间");
			list.add(map);
		}
		return list;
	}
}
