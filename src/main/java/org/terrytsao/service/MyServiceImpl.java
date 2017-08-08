package org.terrytsao.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terrytsao.dao.DAO;

@Service(value = "myService")
@Transactional
public class MyServiceImpl implements MyService {

	@Autowired
	@Qualifier("dao")
	protected DAO dao;

	@Override
	@Transactional
	public <T> void add(T t) {
		dao.add(t);
	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) {
		return dao.getById(type, id);
	}
}
