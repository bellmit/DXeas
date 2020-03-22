package com.kingdee.eas.custom.taihe.settle.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseControllerBean;
import com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseCollection;
import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleAwardPolicyControllerBean extends AbstractSettleAwardPolicyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.settle.app.SettleAwardPolicyControllerBean");

	@Override
	protected boolean checkHasUsed(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		String id=pk.toString();
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1 from CT_CON_BatchContract where FAwardPolicyID=?");
		sql.append(" union select 1 from CT_SET_SettleBill where FAwardsPolicyID=?");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),new Object[]{id,id});
		if(rs.size()>0) {
			return true;
		}
		return false;
	}
    
}