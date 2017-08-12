package org.terrytsao.service;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terrytsao.dao.UserDAO;
import org.terrytsao.model.Pet;
import org.terrytsao.model.User;

@Service
@Transactional
public class UserServiceImpl extends MyServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}

	@Override
	public Set<Pet> getPetsById(Serializable uid) {
		return userDAO.getPetsById(uid);
	}
}
