package br.com.xpg.narutosenjuu.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class UserProvider extends ContentProvider {

	private Context context;
	private DataBase db;

	public UserProvider() {
		
		//get instance of context
		this.context = getContext();
		
		//create instance of database
		db = new DataBase(context, DataBaseContract.DATABASE_NAME,
				DataBaseContract.DATABASE_VERSION);
	}

	@Override
	public int delete(Uri table, String whereClause, String[] whereArgs) {
		int count = 0;
		
		//return db.getWritableDatabase().delete(table, whereClause, whereArgs);
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
