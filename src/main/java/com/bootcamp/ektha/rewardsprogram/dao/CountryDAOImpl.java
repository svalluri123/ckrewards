package com.bootcamp.ektha.rewardsprogram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.bootcamp.ektha.rewardsprogram.entity.Country;
import com.bootcamp.ektha.rewardsprogram.util.DataSourceFactory;
import com.bootcamp.ektha.rewardsprogram.util.DbUtil;

/**
 * COUNTRY DAO CLASS FOR CURD OPERATION RELATED TO COUNTRY
 * @author SV
 *
 */
public class CountryDAOImpl {
	
	/**
	 * Retrieve the country list for populating Select Tag
	 * @return
	 */
	public ArrayList<Country> getCountryList() {
		ArrayList<Country> countryList = new ArrayList<>();
		String query = "SELECT COUNTRY_ID, COUNTRY_NAME FROM COUNTRY";
		Connection connection = null ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = DataSourceFactory.getDataSource().getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Country country = new Country();
				country.setCountryId(rs.getString("COUNTRY_ID"));
				country.setCountryName(rs.getString("COUNTRY_NAME"));
				countryList.add(country);
			}
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
		
		return countryList;
	}

}
