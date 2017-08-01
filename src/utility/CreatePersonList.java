package utility;

import java.util.ArrayList;
import models.*;

public final class CreatePersonList {
	private static ArrayList<Person> PersonList;
	public static void CreateList(){
		PersonList=new ArrayList<Person>();
		PersonList.add(new Person("karenIsHere","fastword","i am a single college student looking for a sugar daddy"));
		PersonList.add(new Person("TomRiddler", "mrfidler", "hello i'm trying this out,hi"));
		PersonList.add(new Person("KaleIsLife","elGwap0","Did you know that going vegan turns boys into men, it "
				+ "actualy comes from anctient medicinal magic that was used by dude i found in an ally, he said "
				+ "i'll teach my ways if you give 3 dollars and belly rub"));
		PersonList.add(new Person("PepeTheCroc","rbitRb1T","i am not troll, i am onnnly a liberator of the mind, now "
				+ "stop what your doin and watch alex jones you libtard"));
		PersonList.add(new Person("GenderFlu1d4Life","Ionlyeatk4le",""));
		PersonList.add(new Person("FeministQueen","DPpower","Online harassment, especially gendered online harassment, "
				+ "is an epidemic. Women are being driven out; they're being driven offline. This isn't just in gaming. "
				+ "This is happening across the board online, especially with women who participate in or work in "
				+ "male-dominated industries."));
		PersonList.add(new Person("MRWoke","st4yW0ke","When You Party I'm On The Treadmill,When You Sleep I'm On The Trea"
				+ "dmill, When I Tweet I'm On TheTreadmill. Remember This"));
		PersonList.add(new Person("jagerMint","PissedWord",""));
		PersonList.add(new Person("BamFino","123456789","And I got a b**** wit me, call her MISS WITHOUT DRAWERS When I'm"
				+ " at the bank, you could call me MR WITHDRAWS "));
		PersonList.add(new Person("MLKDKKK","Milkm1lk","I have a dream that my four little chi1dre!Il will one day "
				+ "live in a nation where they will not be judged by the color of their skin but by the content of "
				+ "their character"));
		CreatePhotos();
	}
	private static void CreatePhotos(){
		for(Person person:PersonList){
			int i=0;
			for(;i<5;i++){
				String color=ranColor();
				Photo photo=new Photo("http://placehold.it/600/"+color,"http://placehold.it/150/"+color,
						person.getUsername()+i,true,person.getUsername());
				photo.addtag("water");
				photo.addtag("crool");
				person.addPhoto(photo);
			}
			for(;i<10;i++){
				String color=ranColor();
				Photo photo=new Photo("http://placehold.it/600/"+color,"http://placehold.it/150/"+color,
						person.getUsername()+i,false,person.getUsername());
				photo.addtag("doesn't matter");
				photo.addtag("koolyo");
				String user;
				while((user=PersonList.get((int )((Math.random() * 10) + 0)).getUsername()).equals(person.getUsername()));
				photo.sharewith(user);
				String user2;
				while((user2=PersonList.get((int )((Math.random() * 10) + 0)).getUsername()).equals(person.getUsername())||
						(user2=PersonList.get((int )((Math.random() * 10) + 0)).getUsername()).equals(user));
				photo.sharewith(user2);
				person.addPhoto(photo);
			}
		}
	}
	private static String ranColor(){
		String color="";
		String[] hex={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		for(int i=0;i<6;i++){
			int a=(int )((Math.random() * 16) + 0);
			color+=hex[a];
		}
		return color;
	}
	
	public static ArrayList<Person> AccessPersonList(){
		return PersonList;
	}
	public static void AddPerson(Person person){
		PersonList.add(person);
	}
	
}
