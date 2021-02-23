import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Livre;

/**
 * 
 */

/**
 * @author manon
 *
 */
public class TestJpa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// Utilisation de la methode find pour récuperer un livre avec son ID 
		Livre livre1 = em.find(Livre.class, 1);
		System.out.println(livre1);
		
		// Récupération des livres
		TypedQuery<Livre> selectAll = em.createQuery("SELECT l FROM Livre l", Livre.class);
		
		List<Livre> listLivres = selectAll.getResultList();
		
		System.out.println(listLivres);
		

	}

}
