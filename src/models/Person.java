package models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "cookie")
	private String cookie;
	
	private ArrayList<Photo> PhotoList;
	
	public Person() {
		
	}
	
	public Person(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Person(String username,String password,String description){
		if(!description.equals(null))
			this.description=description;
		this.username=username;
		this.password=password;
		PhotoList=new ArrayList<Photo>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Photo> getPhotoList() {
		return PhotoList;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public void setPhotoList(ArrayList<Photo> photoList) {
		PhotoList = photoList;
	}
	
	
}
