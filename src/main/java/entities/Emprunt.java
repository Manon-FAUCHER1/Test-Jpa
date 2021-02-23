package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 */
@Entity
@Table(name = "emprunt")
public class Emprunt {
	
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "DATE_DEBUT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	
	@Column(name = "DATE_FIN", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@Column(name = "DELAI", length = 10, nullable = true)
	private Integer delai;

	/////// RELATIONS //////////
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "compo",
		joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
	)
	private List<Livre> livres;
	
	
	/*
	 * Constructor
	 */
	public Emprunt() {}
	
	/////// GETTERS & SETTERS/////////////
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Client getClient() {
		return client;
	}
	

	public void setClient(Client client) {
		this.client = client;
	}
	

	public List<Livre> getLivres() {
		return livres;
	}
	

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	

	@Override
	public String toString() {
		return "Emprunt n° " + id + " : DATE DEBUT -> " + dateDebut + " DATE FIN -> " + dateFin + " DELAI -> " + delai + " jours \n";
	}

}
