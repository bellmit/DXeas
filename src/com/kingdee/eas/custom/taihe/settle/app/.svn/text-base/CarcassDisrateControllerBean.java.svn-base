package com.kingdee.eas.custom.taihe.settle.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo;
import com.kingdee.eas.util.app.DbUtil;

public class CarcassDisrateControllerBean extends AbstractCarcassDisrateControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.settle.app.CarcassDisrateControllerBean");
    
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
		CarcassDisrateInfo info=(CarcassDisrateInfo) model;
		
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_SET_CarcassDisrate set FBaseStatus='1'")
		.append(" where CFCompanyID=?")
		.append(" and fid!=?")
		.append(" and FHouseBefore=?")
		.append(" and FPurchaseType=?")
		.append(" and ((CFEffectDate<=? and CFUneffectDate>=?)")
		.append(" or (CFEffectDate<=? and CFUneffectDate>=?))")
		;
		DbUtil.execute(ctx, sql.toString(), new Object[]{info.getCompany().getString("id"),info.getString("id"),info.isHouseBefore()?1:0,info.getPurchaseType().getValue()
			,new java.sql.Date(info.getEffectDate().getTime()),new java.sql.Date(info.getEffectDate().getTime())
		,new java.sql.Date(info.getUneffectDate().getTime()),new java.sql.Date(info.getUneffectDate().getTime())});
	}
}