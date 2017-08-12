package org.terrytsao.dao;

import java.io.Serializable;
import java.util.Set;

import org.terrytsao.model.Pet;
import org.terrytsao.model.User;

public interface UserDAO extends DAO {

	public User getUser(String userName);

	public Set<Pet> getPetsById(Serializable uid);
}
