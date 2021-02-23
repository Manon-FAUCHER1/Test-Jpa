
package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @author manon * 
 */
@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;
	
	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	/////// RELATIONS //////////
	@ManyToMany
	@JoinTable(name = "compo",
		joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
	)
	private List<Emprunt> emprunts;
	
	/*
	 * Constructor
	 */
	public Livre() {}
	
	/////// GETTERS & SETTERS/////////////
	
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
	
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	

	@Override
	public String toString() {
		return "Livre n° " + id + " : " + titre + " de " + auteur + "\n";
	}

}
