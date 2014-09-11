package br.com.xpg.narutosenjuu.contentprovider;

public interface DataBaseContract {
	
	public static final String DATABASE_NAME = "contacts";
	public static final int DATABASE_VERSION = 1;
	public static final String DROP_DATABASE = "";
	public static final String TABLE_NAME = "contact";
	public static final String COLUMN_ID = "_ID";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String CREATE_DATABASE 
		= "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
		" INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_NAME + 
		" TEXT NOT NULL , " + COLUMN_PHONE + " TEXT NOT NULL )";
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " 
		+ TABLE_NAME;
	
}
