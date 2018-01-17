package com.bootcamp.ektha.rewardsprogram.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
/**
 * DATA SOURCE - JNDI CONNECTION 
 * property file inside META-INF 
 * and in WEB_INF : <code> <resource-ref>
    <description>MySQL Datasource</description>
    <res-ref-name>jdbc/dbpool</res-ref-name>
    <res-type>javax.sql.DataSource</res-type>
    <res-auth>Container</res-auth>
  </resource-ref></code>
 * @author Boot Camp User 06
 *
 */
public class DataSourceFactory {

	private static DataSource datasource = null;
	
	/**
	 * Gets the DATASOURCE CONNECTION FROM THE DBPOOL
	 * @return
	 * @throws NamingException
	 */
	public static DataSource getDataSource() throws NamingException {
		if (datasource == null) {
			datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/dbpool");
		}
		return datasource;
	}
	
	private DataSourceFactory() {
	}

}
