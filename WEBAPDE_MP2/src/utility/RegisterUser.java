package utility;

import models.Person;

public class RegisterUser {
	public static Person TrytoRegister(String username,String password,String description){
		for(Person person:CreatePersonList.AccessPersonList()){
			if(person.getUsername().equals(username))
				return null;
		}
		Person person=new Person(username,password,description);
		CreatePersonList.AddPerson(person);
		return person;
	}
}
