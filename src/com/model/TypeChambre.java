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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypeChambre generated by hbm2java
 */
@Entity
@Table(name = "type_chambre", catalog = "comparateur")
public class TypeChambre implements java.io.Serializable {

	private Integer idTypeChambre;
	private String libelleChambre;

	private Set<Offre> offres = new HashSet<Offre>(0);

	public TypeChambre() {
	}

	public TypeChambre(String libelleChambre) {
		this.libelleChambre = libelleChambre;
	}

	public TypeChambre(String libelleChambre, Set<Offre> disponibilites, Set<Offre> offres) {
		this.libelleChambre = libelleChambre;

		this.offres = offres;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_type_chambre", unique = true, nullable = false)
	public Integer getIdTypeChambre() {
		return this.idTypeChambre;
	}

	public void setIdTypeChambre(Integer idTypeChambre) {
		this.idTypeChambre = idTypeChambre;
	}

	@Column(name = "libelle_chambre", nullable = false)
	public String getLibelleChambre() {
		return this.libelleChambre;
	}

	public void setLibelleChambre(String libelleChambre) {
		this.libelleChambre = libelleChambre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeChambre")
	public Set<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}

}
