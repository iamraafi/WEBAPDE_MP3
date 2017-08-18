package utility;

import java.util.ArrayList;

import models.*;

public class Locate {
	public static Person findPerson(String username){
		for(Person person:CreatePersonList.AccessPersonList()){
			if(person.getUsername().equals(username))return person;
		}
		return null;
	}
	public static ArrayList<Photo> Searching(String logged,String key){
		ArrayList<Photo> PList=new ArrayList<Photo>();
		for(Person person:CreatePersonList.AccessPersonList()){
			for(Photo photo:person.getPhotoList()){
				if((photo.getName().equals(key)||searchtags(key,photo.getTags()))&&(photo.isIspublic()||searchshares(logged,photo.getShares()))){
					PList.add(photo);
				}
			}
		}
		return PList;
	}
	private static boolean searchtags(String key,ArrayList<String> tags){
		for(String ans:tags){
			if(key.equals(ans))return true;
		}
		return false;
	}
	private static boolean searchshares(String user,ArrayList<String> users){
		for(String ans:users){
			if(user.equals(ans))return true;
		}
		return false;
	}
	public static ArrayList<Photo> OPhotoSearching(String logged,ArrayList<Photo> List){
		ArrayList<Photo> PList=new ArrayList<Photo>();
			for(Photo photo:List){
				if(photo.isIspublic()||searchshares(logged,photo.getShares())){
					PList.add(photo);
				}
			}
		return PList;
	}
}
