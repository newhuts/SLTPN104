package com.yofi.sltpn104.activity;

import com.yofi.sltpn104.R;
import com.yofi.sltpn104.adapter.ListMenu;
import com.yofi.sltpn104.helper.SessionControl;
import com.yofi.sltpn104.model.dataMenu;
import com.yofi.sltpn104.utils.FileOperations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Sltpn extends Activity{

	SessionControl sesion = SessionControl.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sltpn);
		ListView listView = (ListView) findViewById(R.id.slptn);
		if (sesion.getSessionManager().getAkses().equals("admin")) {
			listView.setAdapter(new ListMenu(getApplicationContext(), new dataMenu().getMenuutama()));
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Intent intent = new Intent(getApplicationContext(), SubMenu.class);
					if (arg2 == 0) {
						intent.putExtra("menu", "lihat");
					}else if (arg2 == 1) {
						intent.putExtra("menu", "input");
					}else if (arg2 == 2) {
						intent.putExtra("menu", "laporan");
					}
					startActivity(intent);
				}
			});
		}else {
			listView.setAdapter(new ListMenu(getApplicationContext(), new dataMenu().getMenuutamaGuru()));
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					Intent intent = new Intent(getApplicationContext(), SubMenu.class);
					if (arg2 == 0) {
						intent.putExtra("menu", "lihat");
					}else if (arg2 == 1) {
						intent.putExtra("menu", "laporan");
					}
					startActivity(intent);
				}
			});
		}
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.sltpn, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_logout:
			SessionControl.getInstance().getSessionManager().setLogin(false, "");
			Intent intent = new Intent(getApplicationContext(), Splash.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
			finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
