package com.bootcamp.ektha.rewardsprogram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bootcamp.ektha.rewardsprogram.entity.Store;
import com.bootcamp.ektha.rewardsprogram.entity.User;
import com.bootcamp.ektha.rewardsprogram.util.DataSourceFactory;
import com.bootcamp.ektha.rewardsprogram.util.DbUtil;
import com.bootcamp.ektha.rewardsprogram.util.HibernateUtil;

/**
 * DAO CLASS FOR THE CKSTORE TABLE
 * @author SV
 *
 */
public class StoreDAO {
	
	/**
	 * returns the arraylist of the Store
	 * @param stateId
	 * @return
	 */
	public ArrayList<Store> getStoreList(String stateId) {
		
		
		System.out.println("Searching in DAO...." + stateId);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String query = "SELECT * FROM CKSTORE WHERE STORE_ID = " + stateId;
		ArrayList<Store> strList = (ArrayList<Store>) session.createSQLQuery(query);

		System.out.println(strList);
		tx.commit();
		
		return strList;
	}

}
