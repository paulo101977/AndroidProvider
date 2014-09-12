package br.com.xpg.narutosenjuu.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;

public interface DataBaseContract {
	
	public static final String DATABASE_NAME = "users";
	public static final int DATABASE_VERSION = 1;
	public static final String DROP_DATABASE = "";
	public static final String TABLE_NAME = "users";
	public static final String COLUMN_ID = "_ID";
	public static final String COLUMN_NAME = "user_name";
	public static final String COLUMN_PHONE = "phone";
	public static final String CREATE_DATABASE 
		= "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
		" INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_NAME + 
		" TEXT NOT NULL , " + COLUMN_PHONE + " TEXT NOT NULL )";
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " 
		+ TABLE_NAME;
	
	
	//used for UriMatcher
	public static final int ALL_DATA = 10;
	public static final int SINGLE_DATA = 20;
	
	
	public static final String AUTHORITY ="";
	public static final String BASE_PATH = "user";
	
	//the Content Uri for Content Resolver
	public static final Uri CONTENT_URI = Uri.parse("Content://"
			+ AUTHORITY + "/" + BASE_PATH);
	
	public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE 
			+ "/" + BASE_PATH;
	
	public static final String CONTENT_ITEM = ContentResolver.CURSOR_ITEM_BASE_TYPE 
			+ "/" + BASE_PATH;
}
