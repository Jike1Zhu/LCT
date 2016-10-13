package com.jk.Fragement;

import java.util.List;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.Toast;

import com.jk.activity.Bj_info_sr_activity;
import com.jk.dao.InaccountDAO;
import com.jk.model.Tb_inaccount;
import com.jk.model.option;
import com.patrickstar.slidingmenudemo.R;

public class SrFragement extends Fragment {

	private View mView;
	private ListView lv_show;
	private Button btn_tj;
	private List<Tb_inaccount> data;
	private TextView tv_rqsj;
	private int position;
	private Button btn_bc;
	private Button zcbc;
	private MyAdapter adapter;
	

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
		mView = inflater.inflate(R.layout.sr, container, false);
		lv_show = (ListView) mView.findViewById(R.id.lv_show_sr);
		/*
		 * btn_tj = (Button) mView.findViewById(R.id.btn_tj);
		 * btn_tj.setVisibility(1);
		 */
		setHasOptionsMenu(true);
		
		InaccountDAO outinfo = new InaccountDAO(getActivity());
		data = outinfo.getScrollData(0, (int) outinfo.getCount());// getData();
		adapter = new MyAdapter(getActivity());
		lv_show.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		lv_show.setOnCreateContextMenuListener(this);

	}

	/*@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// 添加2个item

		menu.add(0, 1, 0, "编辑");
		menu.add(0, 2, 0, "删除");

		// 得到长按的position
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		position = info.position;
	}*/

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		// Toast.makeText(getActivity(), "asdas", Toast.LENGTH_LONG).show();
		if (lv_show != null) {
			lv_show.setAdapter(null);
			InaccountDAO outinfo = new InaccountDAO(getActivity());
			data = outinfo.getScrollData(0, (int) outinfo.getCount());// getData();
			adapter = new MyAdapter(getActivity());
			lv_show.setAdapter(adapter);
		}
		super.onResume();
	}

	/**
	 * 长按之后的按钮事件
	 *//*
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		option option = new option();
		if (getUserVisibleHint() && option.getOp().equals("2")) {
			Toast.makeText(getActivity(), getUserVisibleHint()+"sr", 100).show();
			InaccountDAO InaccountDAO = new InaccountDAO(getActivity());

			Tb_inaccount Tb_inaccount = data.get(position);
			Intent objIntent = null;
			switch (item.getItemId()) {
			case 1:// 编辑
					// 1. 显示更新的Dialog
				objIntent = new Intent(getActivity(), Bj_info_sr_activity.class);

				// Toast.makeText(getActivity(),id +"____"+
				// Tb_inaccount.getid(),
				// Toast.LENGTH_LONG).show();
				int id = Tb_inaccount.getid();

				Tb_inaccount = InaccountDAO.find(id);

				objIntent.putExtra("id", id + "");

				objIntent.putExtra("Money", Tb_inaccount.getMoney() + "");
				objIntent.putExtra("Time", Tb_inaccount.getTime());
				objIntent.putExtra("Type", Tb_inaccount.getType());

				objIntent.putExtra("Depict", Tb_inaccount.getMark());
				objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(objIntent);

				break;

			case 2:// 删除

				AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
						.create();
				alertDialog.setIcon(R.drawable.key);
				alertDialog.setTitle("系统提示：");
				alertDialog.setMessage("是否删除？");
				alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub

							}
						});
				alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub

								// InaccountDAO.deleteById(Tb_inaccount.getid()
								// + "");
								Toast.makeText(getActivity(), "222",
										Toast.LENGTH_LONG).show();

								// data.remove(position);

								adapter.notifyDataSetChanged();
							}
						});
				alertDialog.show();
				break;

			default:
				break;
			}

			return super.onContextItemSelected(item);
		}
		return false;
	}*/

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
			Tb_inaccount Tb_inaccount = data.get(position);
			holder.tv_type.setText(Tb_inaccount.getType());
			holder.tv_money.setText("￥+" + Tb_inaccount.getMoney() + "");
			holder.tv_data.setText(Tb_inaccount.getTime());

			return convertView;
		}

	}
}