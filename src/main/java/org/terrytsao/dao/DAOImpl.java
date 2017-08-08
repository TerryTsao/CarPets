package org.terrytsao.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOImpl<T> implements DAO<T> {
	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> clazz;

	@Override
	public void add(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public T getById(Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public void setClass(Class<T> clazz) {
		this.clazz = clazz;
	}
}
