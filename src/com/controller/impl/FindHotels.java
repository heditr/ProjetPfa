package com.controller.impl;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.business.IAfficherListeHotels;
import com.model.Hotel;
import com.model.VoVilleHotelPrix;

@ManagedBean
@RequestScoped
public class FindHotels {
	
	@ManagedProperty("#{hotelBusiness}")
	private IAfficherListeHotels afficherHotels;
	private List<Hotel> listHotelsMoinsCher;
	private List<Double> listePrix;
	private List<VoVilleHotelPrix> hotelPerCity;
	public List<Hotel> listeHotelsMoinsCher(){
	
		return afficherHotels.LessExpensive();
		
		
	}
	
	public List<VoVilleHotelPrix> liste(){
		List<VoVilleHotelPrix> l=afficherHotels.hotelsMoinsCherPerPays();
		Iterator<VoVilleHotelPrix> it=l.iterator();
		while (it.hasNext()){
			System.out.println(it.next().getNom_hotel());
		}
		return l;
	}
	public IAfficherListeHotels getAfficherHotels() {
		return afficherHotels;
	}

	public void setAfficherHotels(IAfficherListeHotels afficherHotels) {
		this.afficherHotels = afficherHotels;
	}


	public List<Hotel> getListHotelsMoinsCher() {
		return afficherHotels.LessExpensive();
	}


	public void setListHotelsMoinsCher(List<Hotel> listHotelsMoinsCher) {
		this.listHotelsMoinsCher = listHotelsMoinsCher;
	}



	public void setListePrix(List<Double> listePrix) {
		this.listePrix = listePrix;
	}


	public List<VoVilleHotelPrix> getHotelPerCity() {
		System.out.println("aaaahhhahaahah");
		List<VoVilleHotelPrix> l=afficherHotels.hotelsMoinsCherPerPays();
		System.out.println(l.get(2).getNom_hotel());
		return l;
	}


	public void setHotelPerCity(List<VoVilleHotelPrix> hotelPerCity) {
		this.hotelPerCity = hotelPerCity;
	}
	
}
