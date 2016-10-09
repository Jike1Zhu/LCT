package com.jk.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jk.dao.OutaccountDAO;
import com.jk.model.Tb_outaccount;
import com.patrickstar.slidingmenudemo.R;

public class ZcFragement extends Fragment {

	private View mView;
	private ListView lv_show;
	private Button btn_tj;
	private List<Tb_outaccount> data;
	private TextView tv_rqsj;
	private int position;
	private Button btn_bc;
	private Button zcbc;
	
	private TextView tv_type;
	private TextView tv_money;
	private TextView tv_date;

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
		btn_tj.setVisibility(1);
		OutaccountDAO outinfo = new OutaccountDAO(getActivity());
		 
		data = outinfo.getScrollData(0, (int)outinfo.getCount());
		MyAdapter adapter = new MyAdapter(getActivity());
		lv_show.setAdapter(adapter);

		lv_show.setOnCreateContextMenuListener(this);
		

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// 添加2个item
		menu.add(0, 1, 0, "新增");
		menu.add(0, 2, 0, "编辑");
		menu.add(0, 3, 0, "删除");

		// 得到长按的position
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		position = info.position;
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		// 得到对应的BlackNumber对象
		Intent intent = null;
		switch (item.getItemId()) {
		case 1:// 新增
				// 1. 显示更新的Dialog
			intent = new Intent(getActivity(), Bj_Xz_info.class);
			startActivity(intent);
			break;
		case 2:// 编辑
				// 1). 删除数据表对应的数据

			break;
		case 3:// 删除

			break;

		default:
			break;
		}

		return super.onContextItemSelected(item);
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
			return data.get(position);
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
				tv_type = (TextView) convertView
						.findViewById(R.id.tv_type);
				tv_money = (TextView) convertView
						.findViewById(R.id.tv_money);
				tv_date = (TextView) convertView
						.findViewById(R.id.tv_data);
				// 将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Tb_outaccount tb_outaccount = data.get(position);
			tv_type.setText(tb_outaccount.getType());
			tv_money.setText(tb_outaccount.getMoney()+"");
			tv_date.setText(tb_outaccount.getTime());

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
		
/*		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		OutaccountDAO outinfo = new OutaccountDAO(getActivity());
		List<Tb_outaccount> aa=  outinfo.getScrollData(0, (int)outinfo.getCount());
		String[] str = new String[aa.size()];
		for (Tb_outaccount outaccount:aa) {
			map = new HashMap<String, Object>();
			map.put("type", outaccount.getType());
			map.put("money", outaccount.getMoney());
			map.put("date", outaccount.getTime());
			list.add(map);
		}
		return list;*/
	}
}
