package com.jk.activity;

import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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

public class SrFragement extends   Fragment {

	private View mView;
	private ListView lv_show;
	private Button btn_tj;
	private List<Tb_outaccount> datas;
	private TextView tv_rqsj;
	private int position;
	private Button btn_bc;
	private Button zcbc;
	private MyAdapter adapter;

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
		/*
		 * btn_tj = (Button) mView.findViewById(R.id.btn_tj);
		 * btn_tj.setVisibility(1);
		 */
		setHasOptionsMenu(true);
		OutaccountDAO outinfo = new OutaccountDAO(getActivity());

		datas = outinfo.getScrollData(0, (int) outinfo.getCount());
		adapter = new MyAdapter(getActivity());
		lv_show.setAdapter(adapter);

		lv_show.setOnCreateContextMenuListener(this);

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		MenuInflater inflatermenu = new MenuInflater(getActivity());
		
		inflatermenu.inflate(R.menu.menu1, menu);

		super.onCreateOptionsMenu(menu, inflatermenu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.item1) {
			Intent intent = null;
			intent = new Intent(getActivity(), Xz_info_activity.class);
			
			startActivityForResult(intent, 1);
			/* Toast.makeText(getActivity(), "asdas", Toast.LENGTH_LONG).show(); */
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// 添加2个item

		menu.add(0, 1, 0, "编辑");
		menu.add(0, 2, 0, "删除");

		// 得到长按的position
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		position = info.position;
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
			return datas.size();
		}

		@Override
		public Object getItem(int position) {
			// Get the data item associated with the specified position in the
			// data set.
			// 获取数据集中与指定索引对应的数据项
			return datas.get(position);
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

			// 如果缓存convertView为空，则需要创建View
			if (convertView == null) {

				// 根据自定义的Item布局加载布局
				convertView = mInflater.inflate(R.layout.list_item, null);
				tv_type = (TextView) convertView.findViewById(R.id.tv_type);
				tv_money = (TextView) convertView.findViewById(R.id.tv_money);
				tv_date = (TextView) convertView.findViewById(R.id.tv_data);

			}
			Tb_outaccount tb_outaccount = datas.get(position);
			tv_type.setText(tb_outaccount.getType());
			tv_money.setText(tb_outaccount.getMoney() + "");
			tv_date.setText(tb_outaccount.getTime());

			return convertView;
		}

	}
}