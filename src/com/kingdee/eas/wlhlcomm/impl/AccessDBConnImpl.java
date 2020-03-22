package com.kingdee.eas.wlhlcomm.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.wlhlcomm.interfaces.IDBBean;
import com.kingdee.eas.wlhlcomm.interfaces.IDBConn;

/**
 * ���ݿ���������
 * @author lenovo
 *
 */
public class AccessDBConnImpl implements IDBConn{
	private int dbType; //���ݿ�����
	private String fileAddress;//���ݿ��ļ���ַ
	private String userName;//�û���
	private String password;//����
	private Connection conn=null;
	public int getDbType() {
		return dbType;
	}
	public void setDbType(int dbType) {
		this.dbType = dbType;
	}
	public String getFileAddress() {
		return fileAddress;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	/*
	 * ��ȡ��ʵ��
	 */
	public static AccessDBConnImpl getInstance() {
		return new AccessDBConnImpl();
	}
	
	public  AccessDBConnImpl( ) {
		
	}
	public  AccessDBConnImpl( IDBBean iConn) {
		 setDbType(iConn.getDbType());
		 setFileAddress(iConn.getFileAddress());
		 setUserName(iConn.getUserName());
		 setPassword(iConn.getPassword());
	}
	/*
	 * ��ȡ��ʵ��
	 */
	public static IDBBean getInstance( IDBBean iConn) throws BOSException {
		 AccessDBConnImpl ob = new AccessDBConnImpl();
		 ob.setDbType(iConn.getDbType());
		 ob.setFileAddress(iConn.getFileAddress());
		 ob.setUserName(iConn.getUserName());
		 ob.setPassword(iConn.getPassword());
		 ob.setConn(ob.setConn());
		 return (IDBBean) ob;
	}
	
	public Connection getConn() {
		return conn;
	}
	/**
	 * ��ȡ���ݿ�����
	 * @throws Exception 
	 */
	public Connection setConn() throws BOSException {
		conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			/**
			 * ֱ������access�ļ���
			 */
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + this.fileAddress;
			this.conn = DriverManager.getConnection(url, this.userName, this.password);
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return conn;
	}
	/**
	 * ִ��sql��ѯ
	 * @param sqlStr
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sqlStr) throws SQLException {
		if(this.conn==null)
			return null;
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sqlStr);
		return rs;
	}
	
	/**
	 * ִ��sql
	 * @param sqlStr
	 * @return
	 * @throws SQLException
	 */
	public boolean execute(String sqlStr) throws SQLException {
		if(this.conn==null)
			return false;
		Statement stm = conn.createStatement();
		boolean result = stm.execute(sqlStr);
		return result;
	}
	/**
	 * �ر�����
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		if(this.conn!=null&&!this.conn.isClosed()) {
			conn.close();
		}
	}
	/**
	 * ���� �Զ��ύ
	 * @param flag
	 * @throws SQLException
	 */
	public void setAutoCommit(boolean flag) throws SQLException {
		if(this.conn!=null&&!this.conn.isClosed()) {
			conn.setAutoCommit(flag);
		}
	}
	/**
	 * �ύ
	 * @param flag
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		if(this.conn!=null&&!this.conn.isClosed()) {
			conn.commit();
		}
	}
	/**
	 *  �ع�
	 * @param flag
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		if(this.conn!=null&&!this.conn.isClosed()) {
			conn.rollback();
		}
	}
}
