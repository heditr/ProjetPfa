package com.controller;

import java.util.List;

import com.model.Hotel;
import com.model.Pays;
import com.model.Ville;
import com.model.VoVilleHotelPrix;

public interface ICntrlAffListeHotels {
	
	
	public String ListeHotels();
	public void saveHotel(Hotel hotel);
	public Ville findById(int id);
	public List<Ville> findAll();
	public List<Hotel> findByCritHotel();
	
	
	

}
