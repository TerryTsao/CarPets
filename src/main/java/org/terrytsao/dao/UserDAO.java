package org.terrytsao.dao;

import org.terrytsao.model.User;

public interface UserDAO {

    public void addUser(User user);

	public User getUser(String userName);
}
