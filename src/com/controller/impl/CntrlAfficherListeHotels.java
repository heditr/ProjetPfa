package com.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sun.security.util.BigInt;

import com.business.IAfficherListeHotels;
import com.controller.ICntrlAffListeHotels;
import com.model.Hotel;
import com.model.Pays;
import com.model.Ville;
import com.model.VoVilleHotelPrix;



@ManagedBean
@SessionScoped
public class CntrlAfficherListeHotels implements ICntrlAffListeHotels {
	
	
	@ManagedProperty("#{hotelBusiness}")
	private IAfficherListeHotels bAfficherListeHotel;

	private List<Hotel> listHotels = new ArrayList<Hotel>();
	private Date date_dep;
	private List<Ville> listVille;
	private Ville selectedVille;
	private Pays selectedCountry;
	private String pays_ville;
	
	
	
	public CntrlAfficherListeHotels(){
		
	}
	
	
	@Override
	public String ListeHotels() {
		System.out.println("ListHotels");
			listHotels=findByCritHotel();
		return "success";
	}
	@Override
	public void saveHotel(Hotel hotel){
		
		bAfficherListeHotel.saveHotel(hotel);
	}
	
	@Override
	public List<Hotel> findByCritHotel() {
		System.out.println("****************"+selectedVille.getNomVille()+"************");
		Criterion crit=Restrictions.eq("ville", selectedVille);
		
		
		
		return bAfficherListeHotel.findByCrit(Hotel.class, crit);
	}
	
	

	public Date getDate_dep() {
		return date_dep;
	}

	public void setDate_dep(Date date_dep) {
		this.date_dep = date_dep;
	}

	

	public List<Ville> complete(String query) {
		
		
		List<Ville> suggestions = new ArrayList<Ville>();  
		listVille=findAll();
		
        
        for(Ville p : listVille) {  
            if(p.getNomVille().toLowerCase().startsWith(query.toLowerCase()) || p.getPays().getNomPays().toLowerCase().startsWith(query.toLowerCase()))  
                suggestions.add(p);  
        }  
          
        return suggestions;  
	}
	
	
	@Override
	public Ville findById(int id) {
		
		return bAfficherListeHotel.findById(id);
	}


	


	public List<Hotel> getListHotels() {
		
		return listHotels;
	}


	public void setListHotels(List<Hotel> listHotels) {
		this.listHotels = listHotels;
	}


	public IAfficherListeHotels getbAfficherListeHotel() {
		return bAfficherListeHotel;
	}


	public void setbAfficherListeHotel(IAfficherListeHotels bAfficherListeHotel) {
		this.bAfficherListeHotel = bAfficherListeHotel;
	}


	@Override
	public List<Ville> findAll() {
		
		return bAfficherListeHotel.findAll();
	}


	public Ville getSelectedVille() {
		return selectedVille;
	}


	public void setSelectedVille(Ville selectedVille) {
		this.selectedVille = selectedVille;
	}


	public Pays getSelectedCountry() {
		return selectedCountry;
	}


	public void setSelectedCountry(Pays selectedCountry) {
		this.selectedCountry = selectedCountry;
	}


	public String getPays_ville() {
		return pays_ville;
	}


	public void setPays_ville(String pays_ville) {
		this.pays_ville = pays_ville;
	}


	
	
	
	


	

}
