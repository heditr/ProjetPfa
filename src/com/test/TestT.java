package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controller.impl.CntrlAfficherListeHotels;
import com.model.Hotel;

public class TestT {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/Ressource/applicationContext.xml");

		CntrlAfficherListeHotels afficherListeHotelsImpl = (CntrlAfficherListeHotels) ctx
				.getBean("hotelCntrl");

		List<Hotel> listHotel=new ArrayList<Hotel>();
		listHotel=afficherListeHotelsImpl.getListHotels();
		Iterator<Hotel> it=listHotel.iterator();	
		while(it.hasNext()){
			System.out.println(it.next().getNomHotel());
		}

	}

}
