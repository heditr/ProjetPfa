package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.IGeneriqueDao;

public class GenericDaoImpl extends HibernateDaoSupport implements IGeneriqueDao {

	
	
	public GenericDaoImpl(){
		
	}

	@Override
	public List<Object> findAll(Class clazz) {
		System.out.println("seesssssesssss");
		
		List list;
		// try {

		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from " + clazz.getName());

		list = query.list();
		return list;
	}

	@Override
	public void insert(Object obj) {
		getSessionFactory().getCurrentSession().save(obj);

	}

	public Object findById(Class clazz, Serializable id) {
		Object result = getSessionFactory().getCurrentSession().get(clazz, id);
		return result;

	}

	

	public List findByCriteria(Class clazz, Criterion critere) {
		List objects = null;
		Criteria crit = getSessionFactory().getCurrentSession()
				.createCriteria(clazz).add(critere);
		objects = crit.list();

		return objects;
	}
	
}
