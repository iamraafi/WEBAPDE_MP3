package models;

import java.util.ArrayList;

public class Person {
	private String username;
	private String password;
	private String description="";
	private ArrayList<Photo> PhotoList;
	
	public Person(String username,String password,String description){
		if(!description.equals(null))
			this.description=description;
		this.username=username;
		this.password=password;
		PhotoList=new ArrayList<Photo>();
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<Photo> getPhotoList() {
		return PhotoList;
	}
	
	public void addPhoto(Photo photo){
		this.PhotoList.add(photo);
	}
	
}
