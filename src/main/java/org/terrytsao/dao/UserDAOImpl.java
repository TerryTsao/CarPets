package org.terrytsao.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.terrytsao.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

	@Override
	public User getUser(String userName) {
		Query<User> query = sessionFactory.getCurrentSession()
				.createQuery("from User where userName = :userName",
						User.class);
		return query.setParameter("userName", userName).uniqueResult();
	}
}
