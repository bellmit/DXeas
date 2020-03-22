package com.kingdee.eas.farm.hatch.app;

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

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.hatch.HatchingBoxCollection;
import com.kingdee.eas.farm.hatch.HatchingBoxInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HatchingBoxControllerBean extends AbstractHatchingBoxControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.hatch.app.HatchingBoxControllerBean");
    
    
    @Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
    	// 转箱单或 出雏单引用 校验 
		String sql = " select 1 from CT_FM_BHatchBabyBillEntry where CFHatchingBoxID =?";
		String[] args = {pk.toString()};
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try {
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","该出雏箱已经被出雏单引用，不能删除"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BOSException(e);
		}
		
		
		super._delete(ctx, pk);
	}
}