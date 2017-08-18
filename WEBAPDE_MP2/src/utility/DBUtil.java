package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("webapde");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
