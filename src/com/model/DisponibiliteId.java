package com.model;

// Generated 27 d�c. 2013 02:10:47 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DisponibiliteId generated by hbm2java
 */
@Embeddable
public class DisponibiliteId implements java.io.Serializable {

	private int idTypeChambre;
	private int idHotel;

	public DisponibiliteId() {
	}

	public DisponibiliteId(int idTypeChambre, int idHotel) {
		this.idTypeChambre = idTypeChambre;
		this.idHotel = idHotel;
	}

	@Column(name = "id_type_chambre", nullable = false)
	public int getIdTypeChambre() {
		return this.idTypeChambre;
	}

	public void setIdTypeChambre(int idTypeChambre) {
		this.idTypeChambre = idTypeChambre;
	}

	@Column(name = "id_hotel", nullable = false)
	public int getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DisponibiliteId))
			return false;
		DisponibiliteId castOther = (DisponibiliteId) other;

		return (this.getIdTypeChambre() == castOther.getIdTypeChambre())
				&& (this.getIdHotel() == castOther.getIdHotel());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdTypeChambre();
		result = 37 * result + this.getIdHotel();
		return result;
	}

}
