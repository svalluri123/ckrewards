package com.bootcamp.ektha.rewardsprogram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.bootcamp.ektha.rewardsprogram.entity.User;
import com.bootcamp.ektha.rewardsprogram.util.DataSourceFactory;
import com.bootcamp.ektha.rewardsprogram.util.DbUtil;

/**
 * LOGIN DAO CLASS FOR THE LOGIN RELATED CURD OPERATION
 * @author SV
 *
 */
public class LoginInfoDAO{
	private Connection connection;
	private PreparedStatement ps;
    private ResultSet rs;
	
	/**
	 * CHECKS FOR THE USER EXISTENCE IN THE DATABASE
	 * @param username
	 * @return
	 */
	public boolean isUserExist(String username) {
		boolean isValid = false;
		String query = "SELECT * FROM LOGIN_INFO WHERE USERNAME = ' " + username + " ' ";
		
		try {
			connection = DataSourceFactory.getDataSource().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			isValid = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(connection);
		}
		return isValid;
	}
	

	/**
	 * CHECKS WHETHER USERNAME AND PASSWORD is VALID OR NOT
	 * @param user
	 * @return
	 */
	public boolean isValidCredential(User user) {
		boolean status = false;
		
		String query = "SELECT * FROM LOGIN_INFO WHERE USERNAME = ? AND PASSWORD = ?";
		
		try {
			connection = DataSourceFactory.getDataSource().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(connection);
		}
		return status;
	}
	

	
}
