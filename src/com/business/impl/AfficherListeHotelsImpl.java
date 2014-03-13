package com.business.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.business.IAfficherListeHotels;
import com.dao.IHotelDao;
import com.model.Hotel;
import com.model.Ville;
import com.model.VoVilleHotelPrix;
import com.sun.org.apache.regexp.internal.recompile;



public class AfficherListeHotelsImpl implements IAfficherListeHotels {
	
	
	private IHotelDao hotelDao;
	List listVille;
	private List listHotels = new ArrayList<Hotel>();
	
	
	
	public AfficherListeHotelsImpl(){
		
		System.out.println("hello bean");
		
		
	}
	
	
	@Transactional
	@Override
	public List<Hotel> ListeHotels() {
		try{
		 listHotels= hotelDao.findAll(Hotel.class);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return listHotels;
	}
	@Transactional
	public void saveHotel(Hotel hotel){
		
		try{
		hotelDao.insert(hotel);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	

	public void setListHotels(List listHotels) {
		this.listHotels = listHotels;
	}

	

	public IHotelDao getHotelDao() {
		return hotelDao;
	}
	public void setHotelDao(IHotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}
	@Transactional
	@Override
	public Ville findById(int id) {
		Ville ville=new Ville();
		try{
		 ville=(Ville) hotelDao.findById(Ville.class, id);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return ville;
	}
	
	@Transactional
	@Override
	public List<Ville> findAll() {
		
		listVille=hotelDao.findAll(Ville.class);
//		Iterator<Ville> it=listVille.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().getNomVille());
//		}
		return listVille;
	}

	@Transactional
	@Override
	public List findByCrit(Class clazz, Criterion critere) {
		
		return hotelDao.findByCriteria(clazz, critere);
	}
	@Transactional
	@Override
	public List<Hotel> LessExpensive(){
		
		return hotelDao.findHotelLessExpensive();
	}
	
	@Transactional
	@Override
	public List<VoVilleHotelPrix> hotelsMoinsCherPerPays(){
		 List l=hotelDao.lessExpensiveHotelPerCity();
		 List<VoVilleHotelPrix> li=new ArrayList<VoVilleHotelPrix>();
		 for (Object  p : l){
				VoVilleHotelPrix vo=new VoVilleHotelPrix();
				Object [] oo=(Object[]) p;
				String nom_ville= (String)oo[0];
				String nom_Hotel=(String)oo[1];
				Double prix=(Double)oo[2];
				vo.setNom_ville(nom_ville);
				vo.setNom_hotel(nom_Hotel);
				vo.setPrix(prix);
				li.add(vo);
				
			}
		return li;
		
	}

}
