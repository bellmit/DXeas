package com.kingdee.eas.custom.taihe.weight.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.weight.TransportCoeInfo;
import com.kingdee.eas.util.app.DbUtil;

public class TransportCoeControllerBean extends AbstractTransportCoeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.weight.app.TransportCoeControllerBean");
    
    @Override
	protected void _approve(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._approve(ctx, model);
		updateOtherDataStatus(ctx,model);
	}
	
	/**
	 * 把其他资料状态改为未核准
	 * @param ctx
	 * @param model
	 * @throws BOSException 
	 */
	private void updateOtherDataStatus(Context ctx,IObjectValue model) throws BOSException {
		TransportCoeInfo info=(TransportCoeInfo) model;
		
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_WEI_TransportCoe set FBaseStatus='1'")
		.append(" where CFCompanyID=?")
		.append(" and fid!=?")
		.append(" and ((CFBeginDate<=? and CFEndDate>=?)")
		.append(" or (CFBeginDate<=? and CFEndDate>=?))")
		;
		DbUtil.execute(ctx, sql.toString(), new Object[]{info.getCompany().getString("id"),info.getString("id")
			,new java.sql.Date(info.getBeginDate().getTime()),new java.sql.Date(info.getBeginDate().getTime())
		,new java.sql.Date(info.getEndDate().getTime()),new java.sql.Date(info.getEndDate().getTime())});
	}
    
}