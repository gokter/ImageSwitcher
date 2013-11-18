package com.flyingh.imageswitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	private GridView gridView;
	private ImageSwitcher imageSwitcher;
	private int[] imageResourceIds = { R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridView = (GridView) findViewById(R.id.grid_view);
		imageSwitcher = (ImageSwitcher) findViewById(R.id.image_switcher);
		List<Map<String, Integer>> data = new ArrayList<Map<String, Integer>>();
		for (int imageResourceId : imageResourceIds) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("image", imageResourceId);
			data.add(map);
		}
		gridView.setAdapter(new SimpleAdapter(this, data, R.layout.cell, new String[] { "image" }, new int[] { R.id.image }));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				imageSwitcher.setImageResource(imageResourceIds[position]);
			}

		});
		imageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				return new ImageView(MainActivity.this);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
