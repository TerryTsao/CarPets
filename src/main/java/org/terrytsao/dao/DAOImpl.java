package org.terrytsao.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "dao")
public class DAOImpl implements DAO {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public <T> void add(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) {
		return sessionFactory.getCurrentSession().get(type, id);
	}
}
