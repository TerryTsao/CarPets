package org.terrytsao.service;

import java.io.Serializable;
import java.util.Set;

import org.terrytsao.model.Pet;
import org.terrytsao.model.User;

public interface UserService extends MyService {

	public User getUser(String userName);

	public Set<Pet> getPetsById(Serializable uid);
}
