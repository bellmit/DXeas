package com.kingdee.eas.dep.app;

import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salediscount.SaleDiscountFacadeFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillFactory;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.sd.sale.SaleContractFactory;
import com.kingdee.eas.scm.sd.sale.SaleContractInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;

/**
 * 领料出库单 DEP后台扩展
 * @author USER
 *
 */
public class MaterialReqAppDEP {
	
	
	/**
	 * 中转库领料出库（损耗） 
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void addSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		MaterialReqBillInfo so = MaterialReqBillFactory.getLocalInstance(ctx).getMaterialReqBillInfo(pk);
		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
		if(so.getObjectValue("saleContract") != null){
			SaleContractInfo contractInfo = (SaleContractInfo) so.getObjectValue("saleContract");
			
			String destBostype = so.getBOSType().toString();
			String destObjectID = pk.toString();
			String srcBostype = contractInfo.getBOSType().toString();
			String srcObjectID = contractInfo.getId().toString();
			// 添加关联关系到数据库
			BotpAppCommon.addRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
		}
		
	}
	
	/**
	 * 删除领料出库与 销售合同间的关联关系 
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void removeSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

//		MaterialReqBillInfo so = MaterialReqBillFactory.getLocalInstance(ctx).getMaterialReqBillInfo(pk);
//		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
//		if(so.getObjectValue("saleContract") != null){
//			SaleContractInfo contractInfo = (SaleContractInfo) so.getObjectValue("saleContract");
		if(pk!= null){
			String srcBostype = SaleContractFactory.getLocalInstance(ctx).getType().toString();
			String srcObjectID = "";
			String destBostype = MaterialReqBillFactory.getLocalInstance(ctx).getType().toString();
			String destObjectID = pk.toString();
			// 添加关联关系到数据库
			BotpAppCommon.removeRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
		}
		
	}
}
