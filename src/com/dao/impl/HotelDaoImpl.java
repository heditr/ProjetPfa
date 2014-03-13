package com.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.dao.IHotelDao;
import com.model.Hotel;
import com.model.VoVilleHotelPrix;

public class HotelDaoImpl extends GenericDaoImpl implements IHotelDao {

	@Override
	public List findHotelLessExpensive() {
		String str = "Select o.hotel from Offre o "
				+ "inner join  o.hotel as h "
				+ "inner join o.arrangement as a "
				+ "inner join o.typeChambre as t " + "where o.prix>-1 "
				+ "order by o.prix asc ";
		Query query = getSessionFactory().getCurrentSession().createQuery(str);
		List<Hotel> l = query.setMaxResults(10).list();

		return l;
	}

	public Double listPrix(String s) {
		String str = "select min(o.prix) from Offre o where o.hotel.nomHotel=:nomHotel";
		Query query = getSessionFactory().getCurrentSession().createQuery(str);
		query.setParameter("nomHotel", s);
		return (Double) query.uniqueResult();
	}

	public List lessExpensiveHotelPerCity(){
		String str="SELECT nom_ville, nom_hotel, min( prix ) "+
					"FROM ( "+
					"SELECT v.nom_ville, h.nom_hotel, o.prix "+
					"FROM ville AS v, offre AS o, hotel AS h "+
					"WHERE h.id_ville = v.id_ville "+
					"AND o.id_hotel = h.id_hotel "+
					") AS t "+
					"WHERE t.prix > -1 "+	
					"GROUP BY t.nom_ville";
		Query query= getSessionFactory().getCurrentSession().createSQLQuery(str);
		List ls=query.list();
		
		
		
		return ls;
	}
	
}
