package org.terrytsao.service;

import org.terrytsao.model.User;

public interface UserService extends MyService {

	public User getUser(String userName);
}
