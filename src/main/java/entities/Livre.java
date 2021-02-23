
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author manon * 
 */
@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	private Integer id;
	
	@Column(name = "TITRE", length = 255)
	private String titre;
	
	@Column(name = "AUTEUR", length = 255)
	private String auteur;

	public Livre() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return  id + " : " + titre + " de " + auteur;
	}

		

}
