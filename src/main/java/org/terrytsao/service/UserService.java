package org.terrytsao.service;

import org.terrytsao.model.User;

public interface UserService extends MyService<User> {

	public User getUser(String userName);
}
