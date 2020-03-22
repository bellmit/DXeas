package com.kingdee.eas.custom.salaryvoucher.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo;
import com.kingdee.eas.custom.salaryvoucher.voucherStatus;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.custom.salaryvoucher.ConnectServerCollection;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ConnectServerControllerBean extends AbstractConnectServerControllerBean
{
	/**
	 * 禁用
	 */
	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConnectServerInfo info = (ConnectServerInfo)model;
		info.setStatus(voucherStatus.save);
		super._update(ctx, new ObjectUuidPK(info.getId()),  model);
		//		super._cancel(ctx, pk, model);

	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConnectServerInfo info = (ConnectServerInfo)model;
		if(!check(ctx)){
			info.setStatus(voucherStatus.cancelcancel);
			super._update(ctx, new ObjectUuidPK(info.getId()),  model);
		}
		else{
			throw new EASBizException(new NumericExceptionSubItem("001","只允许存在一个启用的连接"));
		}
		//		super._cancelCancel(ctx, pk, model);
	}

	private Boolean check(Context ctx) {
		// TODO Auto-generated method stub
		String str="select * from T_SAL_ConnectServer where FStatus=3";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str);
			if(rs.next()){
				return true;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ConnectServerInfo info = (ConnectServerInfo)model;
		info.setStatus(voucherStatus.save);
		return super._submit(ctx, model);
	}

	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.salaryvoucher.app.ConnectServerControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}
}