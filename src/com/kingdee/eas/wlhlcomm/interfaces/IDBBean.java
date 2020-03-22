package com.kingdee.eas.wlhlcomm.interfaces;
/**
 * 数据库连接信息接口
 * @author lenovo
 *
 */
public interface IDBBean  {
	final static int ACCESS_VALUE=1;
	int getDbType();
	String getFileAddress();
	String getUserName();
	String getPassword();
	void setFileAddress(String fileAddress);
	void setUserName(String userName);
	void setPassword(String password);
}
