package com.jk.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.patrickstar.slidingmenudemo.R;

/*
 * 首先需要导入项目中的slidingmenulibary.jar
 */

public class MainActivity extends FragmentActivity {

	private TextView tv_zcgl;
	private Button btnSecond;
	private FrameLayout flayout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*requestWindowFeature(Window.FEATURE_NO_TITLE);*/
		setContentView(R.layout.activity_main);
		
		flayout = (FrameLayout) findViewById(R.id.flayout);

		SlidingMenu menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		// 设置触摸屏幕的模式
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 设置菜单界面与主界面中间分割条的宽度
		menu.setShadowWidthRes(R.dimen.shadow_width);
		// 分割条的背景图片
		menu.setShadowDrawable(R.drawable.shadow);

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
		flayout.removeAllViews();
		ZcFragement zc = new ZcFragement();		
		getFragmentManager().beginTransaction().add(R.id.flayout, zc).commit();
	}
	public void Click_sr(View v) {
		flayout.removeAllViews();
		SrFragement sr = new SrFragement();
		getFragmentManager().beginTransaction().add(R.id.flayout, sr).commit();
	}
	public void Click_bq(View v) {
		flayout.removeAllViews();
		BqFragement second = new BqFragement();
		getFragmentManager().beginTransaction().add(R.id.flayout, second).commit();
	}
	public void Click_xtsz(View v) {
		flayout.removeAllViews();
		XtszFragement second = new XtszFragement();
		getFragmentManager().beginTransaction().add(R.id.flayout, second).commit();
	}
	public void Click_tc(View v) {
		
	}

}
