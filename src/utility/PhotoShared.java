package utility;

import java.util.ArrayList;

import models.Person;
import models.Photo;

public class PhotoShared {
	public static ArrayList<Photo> findShares(String name){
		ArrayList<Photo> plist=new ArrayList<Photo>();
		for(Person P:CreatePersonList.AccessPersonList()){
			for(Photo photo:P.getPhotoList()){
				for(String share:photo.getShares()){
					if(share.equals(name))
						plist.add(photo);
				}
			}
		}
		return plist;
	}
}
