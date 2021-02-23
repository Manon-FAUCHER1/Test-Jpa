
package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 */
@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	/**
	 * Constructor
	 */
	public Client() {}
	
	/////// RELATIONS //////////
	@OneToMany(mappedBy = "client")
	private List<Emprunt> emprunt;
	
	
	/////// GETTERS & SETTERS/////////////

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	
	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}
	
	

	@Override
	public String toString() {
		return  "Client n° " + id + " : " + prenom + " " + nom + "\n";
	}
	
}
