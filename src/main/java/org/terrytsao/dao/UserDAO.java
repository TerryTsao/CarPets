package org.terrytsao.dao;

import org.terrytsao.model.User;

public interface UserDAO extends DAO {

	public User getUser(String userName);
}
