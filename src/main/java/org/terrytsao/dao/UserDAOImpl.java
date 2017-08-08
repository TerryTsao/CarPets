package org.terrytsao.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
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
}
