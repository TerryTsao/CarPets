package org.terrytsao.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terrytsao.dao.DAO;

@Service
@Transactional
public class MyServiceImpl<T> implements MyService<T> {

	@Autowired
	protected DAO<T> dao;

	@Override
	@Transactional
	public void add(T t) {
		dao.add(t);
	}

	@Override
	public T getById(Serializable id) {
		return dao.getById(id);
	}
}
