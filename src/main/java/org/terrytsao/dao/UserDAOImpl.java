package org.terrytsao.dao;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.terrytsao.model.Pet;
import org.terrytsao.model.User;

@Repository
public class UserDAOImpl extends DAOImpl implements UserDAO {

	@Override
	public User getUser(String userName) {
		Query<User> query = sessionFactory.getCurrentSession()
				.createQuery("from User where userName = :userName",
						User.class);
		return query.setParameter("userName", userName).uniqueResult();
	}

	@Override
	public Set<Pet> getPetsById(Serializable uid) {
		User user = sessionFactory.getCurrentSession().get(User.class, uid);
		Hibernate.initialize(user.getMyPets());
		return user.getMyPets();
	}
}
