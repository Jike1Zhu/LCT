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
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jk.activity.bq_bj_content_activity;
import com.jk.dao.FlagDAO;
import com.jk.model.Tb_flag;
import com.patrickstar.slidingmenudemo.R;

public class BqFragement extends Fragment {

	private View mView;
	private ListView bq_lv_show;

	private List<Tb_flag> data;

	private int position;

	private MyAdapter adapter;
	public int op;

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
		mView = inflater.inflate(R.layout.bq_list, container, false);
		bq_lv_show = (ListView) mView.findViewById(R.id.bq_lv);
		setHasOptionsMenu(true);
		FlagDAO flagDAO = new FlagDAO(getActivity());
		data = flagDAO.getScrollData(0, (int) flagDAO.getCount());// getData();
		adapter = new MyAdapter(getActivity());
		bq_lv_show.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		bq_lv_show.setOnCreateContextMenuListener(this);
		bq_lv_show.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				FlagDAO flagDAO = new FlagDAO(getActivity());
				Tb_flag tb_flag = data.get(position);
				Intent objIntent = new Intent(getActivity(),
						bq_bj_content_activity.class);
				int id_2 = tb_flag.getid();
				tb_flag = flagDAO.find(id_2);

				objIntent.putExtra("id", tb_flag.getid() + "");

				objIntent.putExtra("Flag", tb_flag.getFlag());
				objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(objIntent);

			}
		});

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		// Toast.makeText(getActivity(), "asdas", Toast.LENGTH_LONG).show();
		if (bq_lv_show != null) {
			bq_lv_show.setAdapter(null);
			FlagDAO flagDAO = new FlagDAO(getActivity());
			data = flagDAO.getScrollData(0, (int) flagDAO.getCount());// getData();
			adapter = new MyAdapter(getActivity());
			bq_lv_show.setAdapter(adapter);
		}
		super.onResume();
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

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		FlagDAO flagDAO = new FlagDAO(getActivity());

		Tb_flag tb_flag = data.get(position);
		Intent objIntent = null;
		switch (item.getItemId()) {
		case 1:
			objIntent = new Intent(getActivity(), bq_bj_content_activity.class);

			// Toast.makeText(getActivity(),id +"____"+ tb_outaccount.getid(),
			// Toast.LENGTH_LONG).show();
			int id = tb_flag.getid();
			tb_flag = flagDAO.find(id);

			objIntent.putExtra("id", id + "");

			objIntent.putExtra("Flag", tb_flag.getFlag());
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

							// flagDAO.deleteById(tb_flag.getid() + "");
							Toast.makeText(getActivity(), "33",
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

	// ViewHolder静态类
	static class ViewHolder {
		public TextView tv_bq_item;

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
			String str = null;
			// 如果缓存convertView为空，则需要创建View
			if (convertView == null) {
				holder = new ViewHolder();
				// 根据自定义的Item布局加载布局
				convertView = mInflater.inflate(R.layout.bq_list_item, null);
				holder.tv_bq_item = (TextView) convertView
						.findViewById(R.id.bq_item);

				// 将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			Tb_flag tb_flag = data.get(position);
			if (tb_flag.getFlag().length() >= 20) {
				str = tb_flag.getFlag().substring(0, 20) + "...";
			} else {
				str = tb_flag.getFlag();
			}
			holder.tv_bq_item.setText(str);

			return convertView;
		}

	}
}
