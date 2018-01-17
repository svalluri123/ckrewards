package com.bootcamp.ektha.rewardsprogram.service;

import com.bootcamp.ektha.rewardsprogram.dao.UserDAO;
import com.bootcamp.ektha.rewardsprogram.entity.User;

public class UserServicesImpl implements UserServices {
	UserDAO userDAO;

	@Override
	public boolean validateUser(User user) {
		
		System.out.println("Trying to find user in service one");
		
		User u = userDAO.findByUserName(user);
		
		System.out.println("Trying to find user in service two");
		
		if(u != null && user != null){
			if (user.getPassword().equals(u.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
