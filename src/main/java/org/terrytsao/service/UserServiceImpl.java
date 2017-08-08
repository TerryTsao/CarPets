package org.terrytsao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terrytsao.dao.UserDAO;
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
}
