package com.kingdee.eas.custom.taihe.settle.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.settle.StdCarassRateInfo;
import com.kingdee.eas.util.app.DbUtil;

public class StdCarassRateControllerBean extends AbstractStdCarassRateControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.settle.app.StdCarassRateControllerBean");

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
		StdCarassRateInfo info=(StdCarassRateInfo) model;
		
		StringBuffer sql=new StringBuffer();
		sql.append(" update T_SET_StdCarassRate set FBaseStatus='1'")
		.append(" where FCompanyID=?")
		.append(" and fid!=?")
		.append(" and FHouseBefore=?")
		.append(" and CFAcquisitionType=?")
		.append(" and ((FEffectDate<=? and FUnEffectDate>=?)")
		.append(" or (FEffectDate<=? and FUnEffectDate>=?))")
		;
		DbUtil.execute(ctx, sql.toString(), new Object[]{info.getCompany().getString("id"),info.getString("id"),info.isHouseBefore()?1:0,info.getAcquisitionType().getValue()
			,new java.sql.Date(info.getEffectDate().getTime()),new java.sql.Date(info.getEffectDate().getTime())
		,new java.sql.Date(info.getUnEffectDate().getTime()),new java.sql.Date(info.getUnEffectDate().getTime())});
	}
    
}