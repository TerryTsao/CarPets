package org.terrytsao.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOImpl<T> implements DAO<T> {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void add(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}
}
