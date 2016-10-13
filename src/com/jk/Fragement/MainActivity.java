package com.jk.Fragement;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jk.activity.Bj_info_sr_activity;
import com.jk.activity.Bj_info_zc_activity;
import com.jk.activity.Xz_info_sr_activity;
import com.jk.activity.Xz_info_zc_activity;
import com.jk.activity.bq_bj_content_activity;
import com.jk.activity.bq_content_activity;
import com.jk.dao.FlagDAO;
import com.jk.dao.InaccountDAO;
import com.jk.dao.OutaccountDAO;
import com.jk.model.Tb_flag;
import com.jk.model.Tb_inaccount;
import com.jk.model.Tb_outaccount;
import com.jk.model.option;
import com.patrickstar.slidingmenudemo.R;

/*
 * 首先需要导入项目中的slidingmenulibary.jar
 */

public class MainActivity extends FragmentActivity {

	private TextView tv_zcgl;
	private Button btnSecond;
	private int op = 1;
	private int zt = 0;
	private View img_btn;
	private FrameLayout flayout;
	private int position1;
	private int position2;
	private int position3;
	private List<Tb_outaccount> data1;
	private List<Tb_inaccount> data2;
	private List<Tb_flag> data3;
	private static Boolean isExit = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* requestWindowFeature(Window.FEATURE_NO_TITLE); */
		setContentView(R.layout.activity_main);

		flayout = (FrameLayout) findViewById(R.id.flayout);
		img_btn = (View) findViewById(R.id.img_btn);
		flayout.removeAllViews();

		ZcFragement zc = new ZcFragement();
		getFragmentManager().beginTransaction().add(R.id.flayout, zc).commit();
		img_btn.setVisibility(View.INVISIBLE);

		SlidingMenu menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		// 设置触摸屏幕的模式
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 设置菜单界面与主界面中间分割条的宽度
		menu.setShadowWidthRes(R.dimen.shadow_width);
		// 分割条的背景图片
		menu.setShadowDrawable(R.drawable.left);

		// 设置滑动菜单视图的宽度
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 设置渐入渐出效果的值
		menu.setFadeDegree(0.35f);
		/**
		 * SLIDING_WINDOW will include the Title/ActionBar in the content
		 * section of the SlidingMenu, while SLIDING_CONTENT does not.
		 */
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		// 为侧滑菜单设置布局
		menu.setMenu(R.layout.leftmenu);
		img_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if (op == 1) {

					Intent intent = null;
					intent = new Intent(MainActivity.this,
							Xz_info_zc_activity.class);

					startActivityForResult(intent, 1);
				} else if (op == 2) {
					Intent intent = new Intent(MainActivity.this,
							Xz_info_sr_activity.class);

					startActivity(intent);
				} else if (op == 3) {
					Intent intent = new Intent(MainActivity.this,
							bq_content_activity.class);

					startActivity(intent);
				}
				// Toast.makeText(MainActivity.this, "aaaaa",
				// Toast.LENGTH_LONG).show();
			}
		});

	
			OutaccountDAO outinfo = new OutaccountDAO(MainActivity.this);
			data1 = outinfo.getScrollData(0, (int) outinfo.getCount());

		
			InaccountDAO objInaccountDAO = new InaccountDAO(MainActivity.this);
			data2 = objInaccountDAO.getScrollData(0, (int) objInaccountDAO.getCount());
			 Toast.makeText(MainActivity.this, data2.size()+"",
			 Toast.LENGTH_LONG).show();
		
			FlagDAO flagDAO = new FlagDAO(MainActivity.this);
			data3 = flagDAO.getScrollData(0, (int) flagDAO.getCount());
		

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		 
		// 添加2个item

		menu.add(0, 1, 0, "编辑");
		menu.add(0, 2, 0, "删除");

		// 得到长按的position
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		if(op == 1){
			position1 = info.position;
		}else if(op == 2){
			position2 = info.position;
		}else if(op == 3){
			position3 = info.position;
		}
		
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		Intent objIntent = null;
		switch (item.getItemId()) {
		case 1:// 编辑
				// 1. 显示更新的Dialog

			if (op == 1) {
				objIntent = new Intent(MainActivity.this,
						Bj_info_zc_activity.class);
				OutaccountDAO outaccountDAO = new OutaccountDAO(
						MainActivity.this);
				
				Tb_outaccount tb_outaccount = data1.get(position1);
				
				int id = tb_outaccount.getid();

				tb_outaccount = outaccountDAO.find(id);

				objIntent.putExtra("id", id + "");

				objIntent.putExtra("Money", tb_outaccount.getMoney() + "");
				objIntent.putExtra("Time", tb_outaccount.getTime());
				objIntent.putExtra("Type", tb_outaccount.getType());
				objIntent.putExtra("Address", tb_outaccount.getAddress());
				objIntent.putExtra("Depict", tb_outaccount.getMark());

				// objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(objIntent);
			} else if (op == 2) {
				InaccountDAO InaccountDAO = new InaccountDAO(MainActivity.this);

				
				Tb_inaccount Tb_inaccount = data2.get(position2);
				
				Toast.makeText(MainActivity.this, position2+"", Toast.LENGTH_LONG).show();
				/*objIntent = new Intent(MainActivity.this,Bj_info_sr_activity.class);

				int id = Tb_inaccount.getid();

				Tb_inaccount = InaccountDAO.find(id);

				objIntent.putExtra("id", id + "");

				objIntent.putExtra("Money", Tb_inaccount.getMoney() + "");
				objIntent.putExtra("Time", Tb_inaccount.getTime());
				objIntent.putExtra("Type", Tb_inaccount.getType());

				objIntent.putExtra("Depict", Tb_inaccount.getMark());
				// objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(objIntent);*/
			} else if (op == 3) {
				FlagDAO flagDAO = new FlagDAO(MainActivity.this);

				/*Tb_flag tb_flag = data3.get(position);
				objIntent = new Intent(MainActivity.this,bq_bj_content_activity.class);

				int id = tb_flag.getid();
				tb_flag = flagDAO.find(id);

				objIntent.putExtra("id", id + "");

				objIntent.putExtra("Flag", tb_flag.getFlag());
				//objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(objIntent);*/
			}

			// Toast.makeText(getActivity(),id +"____"+ tb_outaccount.getid(),
			// Toast.LENGTH_LONG).show();

			break;

		case 2:// 删除
			Builder bundle = new AlertDialog.Builder(MainActivity.this);
			bundle.setTitle("提示：");
			bundle.setMessage("确定要关闭吗？");
			bundle.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1) {

						}
					});
			bundle.setNegativeButton("取消", null);
			bundle.create().show();
			break;

		default:
			break;
		}

		return super.onContextItemSelected(item);

	}

	@Override
	protected void onStart() {
		super.onStart();

		/*
		 * btnFirst = (Button)findViewById(R.id.btnFirst);
		 * btnFirst.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { flayout.removeAllViews();
		 * FirstFragement first = new FirstFragement();
		 * getFragmentManager().beginTransaction().add(R.id.flayout,
		 * first).commit();
		 * 
		 * } }); btnSecond = (Button)findViewById(R.id.btnSecond);
		 * btnSecond.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { flayout.removeAllViews();
		 * SecondFragement second = new SecondFragement();
		 * getFragmentManager().beginTransaction().add(R.id.flayout,
		 * second).commit();
		 * 
		 * } });
		 */

	}

	public void Click_zc(View v) {

		op = 1;
		img_btn.setVisibility(View.VISIBLE);
		flayout.removeAllViews();

		ZcFragement zc = new ZcFragement();
		option option = new option();
		option.setOp("3");
		getFragmentManager().beginTransaction().add(R.id.flayout, zc).commit();

	}

	public void Click_sr(View v) {

		op = 2;
		img_btn.setVisibility(View.VISIBLE);
		flayout.removeAllViews();

		SrFragement sr = new SrFragement();
		option option = new option();
		option.setOp("3");
		getFragmentManager().beginTransaction().add(R.id.flayout, sr).commit();
	}

	public void Click_bq(View v) {

		op = 3;

		img_btn.setVisibility(View.VISIBLE);
		flayout.removeAllViews();

		BqFragement second = new BqFragement();
		option option = new option();
		option.setOp("3");
		getFragmentManager().beginTransaction().add(R.id.flayout, second)
				.commit();

	}

	public void Click_xtsz(View v) {
		img_btn.setVisibility(View.INVISIBLE);
		flayout.removeAllViews();
		XtszFragement second = new XtszFragement();
		getFragmentManager().beginTransaction().add(R.id.flayout, second)
				.commit();
	}

	public void Click_tc(View v) {
		exitBy2Click();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitBy2Click(); // 调用双击退出函数
		}
		return false;
	}

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		} else {
			finish();
			System.exit(0);
		}
	}
}
