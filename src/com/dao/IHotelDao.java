package com.dao;

import java.util.List;

import com.model.VoVilleHotelPrix;


public interface IHotelDao extends IGeneriqueDao {
	
	public abstract List findHotelLessExpensive();
	public Double listPrix(String s);
	public List lessExpensiveHotelPerCity();
}
