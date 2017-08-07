package org.terrytsao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.terrytsao.dao.DAO;

public class ServiceImpl<T> implements Service<T> {
	@Autowired
	protected DAO<T> dao;

	@Override
	@Transactional
	public void add(T t) {
		dao.add(t);
	}

}
