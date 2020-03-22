package com.kingdee.eas.custom.commld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUntils {

	
	/**
	 * 连接外部数据库
	 * @param str
	 * @return
	 */
	public static Connection getDataBaseConnection(String [] str){
		Connection conn=null;
		if(str.length==5){
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	            String url = "jdbc:oracle:thin:@"+str[0]+":"+str[1]+":"+str[2]; // orcl为数据库的SID
	            String user = str[3];
	            String password = str[4];
	            conn = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            //throw new BOSException("",e);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return conn;
		}
		return null;
	}
}
