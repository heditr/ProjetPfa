package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface IGeneriqueDao{

	public List<Object> findAll(Class clazz);
	public void insert(Object obj);
	public Object findById(Class clazz,Serializable id);
	public List findByCriteria(Class clazz, Criterion critere);
	
	
}
