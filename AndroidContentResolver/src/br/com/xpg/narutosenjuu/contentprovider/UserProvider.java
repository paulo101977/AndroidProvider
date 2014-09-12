package br.com.xpg.narutosenjuu.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class UserProvider extends ContentProvider {

	private DataBase db;

	// UriMatcher
	private static final UriMatcher uriMatcher = new UriMatcher(
			UriMatcher.NO_MATCH);
	static {
		uriMatcher.addURI(DataBaseContract.AUTHORITY,
				DataBaseContract.BASE_PATH, DataBaseContract.ALL_DATA);

		uriMatcher
				.addURI(DataBaseContract.AUTHORITY, DataBaseContract.BASE_PATH
						+ "/#", DataBaseContract.SINGLE_DATA);
	}

	@Override
	public boolean onCreate() {
		db = new DataBase(getContext(), DataBaseContract.DATABASE_NAME,
				DataBaseContract.DATABASE_VERSION);

		return true;
	}

	@Override
	public int delete(Uri table, String whereClause, String[] whereArgs) {
		int count = 0;

		// return db.getWritableDatabase().delete(table, whereClause,
		// whereArgs);
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

	// need implementation
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		builder.setTables(DataBaseContract.TABLE_NAME);

		int uriType = uriMatcher.match(uri);

		SQLiteDatabase database = db.getWritableDatabase();

		switch (uriType) {
		case DataBaseContract.ALL_DATA:
			break;

		case DataBaseContract.SINGLE_DATA:
			builder.appendWhere(DataBaseContract.COLUMN_ID +
					" = " + uri.getLastPathSegment());
			break;
			
		default:
			throw new IllegalArgumentException();
		}

		Cursor cursor = builder.query(database, projection, selection,
				selectionArgs, null, null, sortOrder);
		//notify the changes
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
