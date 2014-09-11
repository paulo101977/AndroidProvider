package br.com.xpg.narutosenjuu.contentprovider;

public class User {
	
	private int id;
	private String name;
	private String phone;
	
	public User(){
		
	}
	
	public User(int id , String name , String phone){
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public String phone(){
		return phone;
	}

	public int getID()
	{
		return id;
	}
}
