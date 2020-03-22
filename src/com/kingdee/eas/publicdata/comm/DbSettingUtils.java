package com.kingdee.eas.publicdata.comm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.publicdata.DatabaseSettingInfo;
import com.kingdee.eas.publicdata.dbType;
import com.kingdee.eas.wlhlcomm.bean.AccessDBConnBean;
import com.kingdee.eas.wlhlcomm.impl.AccessDBConnImpl;
import com.kingdee.eas.wlhlcomm.interfaces.IDBBean;
import com.kingdee.eas.wlhlcomm.interfaces.IDBConn;

/**
 * 数据库连接 功能类
 * @author lenovo
 *
 */
public class DbSettingUtils {
	public  IDBConn getDbConnection (DatabaseSettingInfo info) throws BOSException {
		if(info==null)
			return null;
		IDBConn iconn=null;
		IDBBean ibean=null;
		if(info.getDbType().equals(dbType.access)) {
			ibean=new AccessDBConnBean();
			ibean.setFileAddress(info.getDbFileAddress());
			ibean.setUserName(info.getUserName());
			ibean.setPassword(info.getPassword());
			iconn=(IDBConn) AccessDBConnImpl.getInstance(ibean);
		}
		return iconn;
	}
	
}
