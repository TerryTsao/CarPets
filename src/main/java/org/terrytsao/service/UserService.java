package org.terrytsao.service;

import org.terrytsao.model.User;

public interface UserService extends Service<User> {

	public User getUser(String userName);
}
