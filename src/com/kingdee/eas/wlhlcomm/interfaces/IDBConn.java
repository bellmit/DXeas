package com.kingdee.eas.wlhlcomm.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBConn {
	
	Connection getConn();

	ResultSet executeQuery(String sqlStr) throws SQLException;

	boolean execute(String sqlStr) throws SQLException;

	void close() throws SQLException;

	void setAutoCommit(boolean flag) throws SQLException;

	void commit() throws SQLException;

	void rollback() throws SQLException;
}
