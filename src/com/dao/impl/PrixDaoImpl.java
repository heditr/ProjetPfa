package com.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.dao.IPrixDao;
import com.model.Hotel;

public class PrixDaoImpl extends GenericDaoImpl implements IPrixDao {

	public List<Double> listePrix(){
		
		String str = "Select o.prix from Offre o "
				+ "inner join  o.hotel as h " + "inner join o.arrangement as a "
				+ "inner join o.typeChambre as t " +
				"where o.prix>-1 "+
				"order by o.prix asc ";
		Query query=getSessionFactory().getCurrentSession().createQuery(str);
		List<Double> l=query.setMaxResults(10).list();
		return l;
	}
}
