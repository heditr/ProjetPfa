package com.model;

// Generated 27 d�c. 2013 02:10:47 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ville generated by hbm2java
 */
@Entity
@Table(name = "ville", catalog = "comparateur")
public class Ville implements java.io.Serializable {

	private Integer idVille;
	private Pays pays;
	private String nomVille;
	private Set<Hotel> hotels = new HashSet<Hotel>(0);
	

	public Ville() {
	}

	public Ville(String nomVille) {
		this.nomVille = nomVille;
	}

	public Ville(Pays pays, String nomVille, Set<Hotel> hotels) {
		this.pays = pays;
		this.nomVille = nomVille;
		this.hotels = hotels;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ville", unique = true, nullable = false)
	public Integer getIdVille() {
		return this.idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Pays")
	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Column(name = "nom_ville", nullable = false)
	public String getNomVille() {
		return this.nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ville")
	public Set<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	

	
}
