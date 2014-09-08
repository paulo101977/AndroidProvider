package br.com.xpg.narutosenjuu.contentprovider;

public interface DataBaseContract {
	
	public static final String DATABASE_NAME = "CONTACTS";
	public static final int DATABASE_VERSION = 1;
	public static final String DROP_DATABASE = "";
	public static final String TABLE_NAME = "CONTACT";
	public static final String NAME = "name";
	public static final String ID = "_ID";
	public static final String CREATE_DATABASE 
		= "CREATE TABLE" + TABLE_NAME + "(";
	
}
