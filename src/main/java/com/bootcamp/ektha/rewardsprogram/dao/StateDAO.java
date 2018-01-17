package com.bootcamp.ektha.rewardsprogram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.bootcamp.ektha.rewardsprogram.entity.State;
import com.bootcamp.ektha.rewardsprogram.util.DataSourceFactory;
import com.bootcamp.ektha.rewardsprogram.util.DbUtil;
/**
 * @author SV
 * Get the State related Information from database
 */
public class StateDAO {

	/**
	 *  Get States List By Country Id 
	 * @param countryId
	 * @return
	 */
    // could have returned HashMap<String, String>
	public ArrayList<State> getStatesListByCountryId(String countryId) {
		Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		ArrayList<State> stateList = new ArrayList<>();
		String query = "SELECT STATE_ID, STATE_NAME "
				+ "FROM STATES "
				+ "WHERE COUNTRY_ID = '" + countryId + "'";
		
		try {
			connection = DataSourceFactory.getDataSource().getConnection();
			ps = (PreparedStatement) connection.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()){
				State state = new State();
				state.setStateId(rs.getString("STATE_ID"));
				state.setStateName(rs.getString("STATE_NAME"));
				stateList.add(state);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(connection);
		}
		
		return stateList;
	}
	
}
