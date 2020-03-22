package com.kingdee.eas.dep.app;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillFactory;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;

/**
 * 库存调拨单 dep后台代码
 * @author USER
 *
 */
public class StockTransferBillAppDEP {

	/**
	 * 大客户调回时 手选签呈  后台 添加关联关系
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void addSignForTableRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		StockTransferBillInfo so = StockTransferBillFactory.getLocalInstance(ctx).getStockTransferBillInfo(pk);
		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
		if(so.getObjectValue("SignTable") != null){
			SignWasTheTableInfo signTableInfo = (SignWasTheTableInfo) so.getObjectValue("SignTable");
			
			String destBostype = so.getBOSType().toString();
			String destObjectID = pk.toString();
			String srcBostype = signTableInfo.getBOSType().toString();
			String srcObjectID = signTableInfo.getId().toString();
			// 添加关联关系到数据库
			BotpAppCommon.addRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
		}
		
	}
	
	/**
	 * 删除库存调拨单时，删除 库存调拨单和签呈的关联关系
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void removeSignForTableRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

//		StockTransferBillInfo so = StockTransferBillFactory.getLocalInstance(ctx).getStockTransferBillInfo(pk);
//		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
//		if(so.getObjectValue("SignTable") != null){
//			SignWasTheTableInfo signTableInfo = (SignWasTheTableInfo) so.getObjectValue("SignTable");
			if(pk != null){
				String destBostype = StockTransferBillFactory.getLocalInstance(ctx).getType().toString();
				String destObjectID = pk.toString();
				String srcBostype = SignWasTheTableFactory.getLocalInstance(ctx).getType().toString();
				String srcObjectID = "";
				// 添加关联关系到数据库
				BotpAppCommon.removeRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
			}
//		}
		
	}
}
