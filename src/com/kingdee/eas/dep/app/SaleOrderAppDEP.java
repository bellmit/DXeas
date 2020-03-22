package com.kingdee.eas.dep.app;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salediscount.SaleDiscountFacadeFactory;
import com.kingdee.eas.scm.sd.sale.SaleContractFactory;
import com.kingdee.eas.scm.sd.sale.SaleContractInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;




/**
 * 销售订单 后台扩展
 * @author USER
 * 
 */
public class SaleOrderAppDEP {
	
	/**
	 * 审核时执行业务功能
	 * @param ctx
	 * @param pk
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void afterAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
		if(!so.getBoolean("hasUseDis")){
			BigDecimal useDis = so.getBigDecimal("useDis");
			if(useDis != null && useDis.compareTo(BigDecimal.ZERO) > 0){
				String companyID = so.getSaleOrgUnit().getId().toString();
				String customerID = so.getOrderCustomer().getId().toString();
				SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(companyID,customerID,useDis,null);
				// 更新订单使用折让状态
				updateOrderBillUseDisState(ctx,so.getId().toString(),true);
				
			}
		}
		
	}
	
	
	/**
	 * 反审核时执行业务功能
	 * @param ctx
	 * @param pk
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void afterUnAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
		if(so.getBoolean("hasUseDis")){
			BigDecimal useDis = so.getBigDecimal("useDis");
			if(useDis != null && useDis.compareTo(BigDecimal.ZERO) > 0){
				String companyID = so.getSaleOrgUnit().getId().toString();
				String customerID = so.getOrderCustomer().getId().toString();
				SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(companyID,customerID,null,useDis);
				// 更新订单使用折让状态
				updateOrderBillUseDisState(ctx,so.getId().toString(),false);
				
			}
		}
		
	}
	/**
	 * 更新订单 已使用折让 状态
	 * @param ctx
	 * @param orderID
	 * @throws BOSException 
	 */
	public void updateOrderBillUseDisState(Context ctx,String orderID,boolean hasUseDis) throws BOSException{
		String sql = "update t_sd_saleorder set cfhasusedis=? where fid=? ";
		Object[] args ={Boolean.valueOf(hasUseDis),orderID};
		DbUtil.execute(ctx, sql,args);
	}
	/**
	 * 更新客户余额
	 * @param ctx
	 * @param companyID
	 * @param customerID
	 * @param useDis
	 * @param addOrSub
	 * @throws BOSException 
	 */
	@Deprecated
	public void updateCustomerBalance(Context ctx,String companyID, String customerID,BigDecimal substractAmount, BigDecimal addAmount) throws BOSException{
		// 公司、客户不为空 同时减少和增加金额不能同时为空
		if(StringUtils.isNotBlank(companyID) &&
				StringUtils.isNotBlank(customerID) && !(
						substractAmount == null && addAmount == null) ){
			SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(companyID, customerID, substractAmount, addAmount);
		}
	}
	
	
	/**
	 * 合同外销售时后台 建立订单与合同的关联关系
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void addSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
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
	 * 删除订单与 销售合同间的关联关系 
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void removeSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

//		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
//		// 折让尚未生效 则执行代码，走则不执行，解决dep调用多次 问题
//		if(so.getObjectValue("saleContract") != null){
//			SaleContractInfo contractInfo = (SaleContractInfo) so.getObjectValue("saleContract");
			if(pk != null){
				String destBostype = SaleOrderFactory.getLocalInstance(ctx).getType().toString();
				String destObjectID = pk.toString();
				String srcBostype = SaleContractFactory.getLocalInstance(ctx).getType().toString();
				String srcObjectID = "";
				// 添加关联关系到数据库
				BotpAppCommon.removeRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
			}
//		}
		
	}
}
