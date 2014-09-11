package br.com.xpg.narutosenjuu.contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

	private static final String groupBy = null;

	public DataBase(Context context, String name, int version) {
		super(context, DataBaseContract.DATABASE_NAME, null,
				DataBaseContract.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqldb) {
		sqldb.execSQL(DataBaseContract.CREATE_DATABASE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqldb, int arg1, int arg2) {
		// TODO Auto-generated method stub
		sqldb.execSQL(DataBaseContract.DROP_DATABASE);

		onCreate(sqldb);
	}

	public Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String having, String orderBy) {
		// TODO Auto-generated method stub
		return getWritableDatabase().query(table, columns, selection,
				selectionArgs, groupBy, having, orderBy);
	}

}
