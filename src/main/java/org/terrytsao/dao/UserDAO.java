package org.terrytsao.dao;

import org.terrytsao.model.User;

public interface UserDAO extends DAO<User> {

	public User getUser(String userName);
}
