package utility;

import java.util.ArrayList;

import models.Person;

public class LogInCheck {
	public static Person LoggingIn(String username,String password){
		ArrayList<Person> PList=CreatePersonList.AccessPersonList();
		for(Person person:PList){
			if((person.getPassword().equals(password))
					&&(person.getUsername().equals(username)))
				return person;
		}
		return null;
	}
}
