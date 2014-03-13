package com.model;

// Generated 27 d�c. 2013 02:10:47 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Disponibilite generated by hbm2java
 */
@Entity
@Table(name = "disponibilite", catalog = "comparateur")
public class Disponibilite implements java.io.Serializable {

	private DisponibiliteId id;
	private TypeChambre typeChambre;
	private Hotel hotel;
	private Date dateArrive;
	private Date dateDepart;
	private String disponible;

	public Disponibilite() {
	}

	public Disponibilite(DisponibiliteId id, TypeChambre typeChambre,
			Hotel hotel, String disponible) {
		this.id = id;
		this.typeChambre = typeChambre;
		this.hotel = hotel;
		this.disponible = disponible;
	}

	public Disponibilite(DisponibiliteId id, TypeChambre typeChambre,
			Hotel hotel, Date dateArrive, Date dateDepart, String disponible) {
		this.id = id;
		this.typeChambre = typeChambre;
		this.hotel = hotel;
		this.dateArrive = dateArrive;
		this.dateDepart = dateDepart;
		this.disponible = disponible;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idTypeChambre", column = @Column(name = "id_type_chambre", nullable = false)),
			@AttributeOverride(name = "idHotel", column = @Column(name = "id_hotel", nullable = false)) })
	public DisponibiliteId getId() {
		return this.id;
	}

	public void setId(DisponibiliteId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_chambre", nullable = false, insertable = false, updatable = false)
	public TypeChambre getTypeChambre() {
		return this.typeChambre;
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hotel", nullable = false, insertable = false, updatable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_arrive", length = 10)
	public Date getDateArrive() {
		return this.dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_depart", length = 10)
	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Column(name = "disponible", nullable = false, length = 30)
	public String getDisponible() {
		return this.disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

}
