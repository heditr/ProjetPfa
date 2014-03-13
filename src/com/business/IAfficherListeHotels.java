package com.business;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.model.Hotel;
import com.model.Ville;
import com.model.VoVilleHotelPrix;

public interface IAfficherListeHotels {
	
	
	public List<Hotel> ListeHotels();
	public void saveHotel(Hotel hotel);
	public Ville findById(int id);
	public List<Ville> findAll();
	public List findByCrit(Class clazz, Criterion critere);
	public List<Hotel> LessExpensive();
	public List<VoVilleHotelPrix> hotelsMoinsCherPerPays();
	

}
