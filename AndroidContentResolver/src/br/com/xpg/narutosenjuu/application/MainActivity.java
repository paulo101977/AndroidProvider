package br.com.xpg.narutosenjuu.application;

import java.util.ArrayList;
import java.util.List;

import com.example.androidcontentresolver.R;

import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_resolver);

		final ListView list = (ListView) findViewById(R.id.list_view);

		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null,
				null);
		final List<String> paths = new ArrayList<String>();

		if (cursor != null && cursor.moveToFirst())
			while (cursor.moveToNext()) {
				paths.add(cursor.getString(cursor
						.getColumnIndex(MediaStore.Images.ImageColumns.DATA)));
			}

		Log.d("Cursor Size : ", "" + cursor.getCount());
		Log.d("Size : ", "" + paths.size());

		final Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				list.setAdapter(
						new ListAdapter(MainActivity.this, paths , list));
				list.invalidate();
				Log.d("update ", "update after 4 seconds");
				handler.postDelayed(this,4000);
			}
		}, 4000);
		
	}

	

	private class ListAdapter extends BaseAdapter {

		private List<String> paths;
		private Context context;
		private ListView v;

		public ListAdapter(Context context, List<String> paths , ListView v) {
			this.context = context;
			this.paths = paths;
			this.v = v;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return paths.size();
		}

		@Override
		public Object getItem(int item) {
			// TODO Auto-generated method stub
			return item;
		}

		@Override
		public long getItemId(int index) {
			// TODO Auto-generated method stub
			return index;
		}

		@Override
		public View getView(int index, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView view = new ImageView(context);
			Bitmap b = BitmapFactory.decodeFile(paths.get(index));
			view.setScaleType(ImageView.ScaleType.CENTER_CROP);
			view.setLayoutParams(new AbsListView.LayoutParams(v.getWidth(),200));
			view.setImageBitmap(b);
			return view;
		}

	}

}
