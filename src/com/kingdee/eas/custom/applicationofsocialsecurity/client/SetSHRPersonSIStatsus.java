/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.jdbcUntils;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SetSHRPersonSIStatsus extends AbstractSetSHRPersonSIStatsus
{
	private static final Logger logger = CoreUIObject.getLogger(SetSHRPersonSIStatsus.class);

	
	Connection conn=null;
	DataBaseConnectionInfo dataBaseConnectionInfo=null;
	/**
	 * output class constructor
	 */
	public SetSHRPersonSIStatsus() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}


	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		//数据库连接配置
		CoreBaseCollection coll = DataBaseConnectionFactory.getRemoteInstance().getCollection("where billStatus=3");
		if(coll.size()==0)
			commUtils.giveUserTipsAndRetire("没有启用的sHR数据库连接配置");
		 dataBaseConnectionInfo = (DataBaseConnectionInfo) coll.get(0);
		 String [] str={dataBaseConnectionInfo.getIP(),dataBaseConnectionInfo.getPort(),dataBaseConnectionInfo.getDataBaseName(),dataBaseConnectionInfo.getUserName(),dataBaseConnectionInfo.getPassword()};
		 conn=jdbcUntils.getDataBaseConnection(str);
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		String str="select fname from CT_BD_SocialSecurityStatus";
		PreparedStatement state = conn.prepareStatement(str);
		ResultSet rs = state.executeQuery(str);
		while(rs.next())
			cBoxSIStatus.addItem(rs.getString("fname"));
	}

	@Override
	protected void btnConfirm_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.btnConfirm_mouseClick(e);
	}

	
}