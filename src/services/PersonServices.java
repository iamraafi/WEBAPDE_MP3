package services;

import javax.persistence.EntityManager;

import models.Person;
import utility.DBUtil;

public class PersonServices {
	public static Person dummyLogin(String username, String password ) {
		//COPIED DIRECTLY FROM SAMPLES
		System.out.println("dummylogins:" + username + " " + password);
		
		if ("stephen".equals(username) && "tan".equals(password)) {
			System.out.println("Person services approve login");
			// generate cookie here for remember me to return to servlet and
			// save as cookie

			return new Person(username, password);
		}
		return null;
	}
	
	//KAILANGAN PA PALA NG COOKIE HAHAHAHA
//	// actual database access to call login and generate cookie if needed
//		public static Person login(String username, String password, boolean isRememberMe) {
//			// get entity manager
//			EntityManager em = DBUtil.getEntityManager();
//			// create query and pass :username and :password parameters
//			Query query = em.createQuery("select p from Person as p where p.username=:username and p.password=:password");
//			query.setParameter("username", username); // note username and password
//														// are base on the parameter
//														// :username and :password
//														// without the ':'
//			query.setParameter("password", password); // usually password should be
//														// encrypted before saving
//			// for the sake of this example, we just simply use the actual password
//			try {
//
//				Person person = (Person) query.getSingleResult();
//				if (isRememberMe) {
//					// do something to generate a cookie
//					// for next meeting's lesson
//				}
//				return person;
//			} catch (NoResultException e) {
//				return null;
//			} finally {
//				em.close();
//			}
//		}
	
	public static Person createPerson(String username, String password, String description) {
		//initialization process
		Person person = new Person();
		person.setUsername(username);
		person.setPassword(password);
		person.setDescription(description);
		
		EntityManager em = DBUtil.getEntityManager();
		
		//create transaction
		em.getTransaction().begin();
		em.persist(person); //not yet saved to db
		em.getTransaction().commit(); //saves to db
		em.close();
		
		return person;
	}
}
