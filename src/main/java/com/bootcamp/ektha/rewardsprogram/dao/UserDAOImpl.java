package com.bootcamp.ektha.rewardsprogram.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bootcamp.ektha.rewardsprogram.entity.User;
import com.bootcamp.ektha.rewardsprogram.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User findByUserName(User user) {

		System.out.println("Searching in DAO...." + user.getUsername());

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User usr = (User) session.load(User.class, new String(user.getUsername()));

		System.out.println(usr);
		tx.commit();
		
		return usr;
	}

}
