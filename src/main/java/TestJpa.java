import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Utils.Color;
import entities.Client;
import entities.Emprunt;
import entities.Livre;

/**
 * 
 */

/**
 * @author manon
 *
 */
public class TestJpa {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// Récupération du livre a l'id 1 avec la méthode find()
		Livre livre1 = em.find(Livre.class, 1);
		System.out.println(ANSI_YELLOW + livre1 + ANSI_RESET);
		
		// Récupération des livres avec la méthode createQuery()
		TypedQuery<Livre> selectAll = em.createQuery("SELECT l FROM Livre l", Livre.class);
		List<Livre> listLivres = selectAll.getResultList();
		System.out.println(ANSI_YELLOW + listLivres + "\n" + ANSI_RESET);
		
		// Extraire un emprunt en fonction de son ID et afficher les livres associés	
		Emprunt emprunt = em.find(Emprunt.class, 1);
		System.out.print(ANSI_YELLOW + emprunt + ANSI_RESET);
		
		for(Livre livre : emprunt.getLivres()) {
			System.out.print(ANSI_YELLOW + livre + ANSI_RESET);
		}
		System.out.println("\n");
		
		// Requête qui permet d’extraire tous les emprunts d’un client donné
		Client client = em.find(Client.class, 1);
		System.out.print(ANSI_YELLOW + client + ANSI_RESET);
		
		for(Emprunt emp : client.getEmprunt()) {
			System.out.print(ANSI_YELLOW + emp + ANSI_RESET);
		}
		System.out.println("\n");
		
	}

}
