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
 * ���۶��� ��̨��չ
 * @author USER
 * 
 */
public class SaleOrderAppDEP {
	
	/**
	 * ���ʱִ��ҵ����
	 * @param ctx
	 * @param pk
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void afterAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
		// ������δ��Ч ��ִ�д��룬����ִ�У����dep���ö�� ����
		if(!so.getBoolean("hasUseDis")){
			BigDecimal useDis = so.getBigDecimal("useDis");
			if(useDis != null && useDis.compareTo(BigDecimal.ZERO) > 0){
				String companyID = so.getSaleOrgUnit().getId().toString();
				String customerID = so.getOrderCustomer().getId().toString();
				SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(companyID,customerID,useDis,null);
				// ���¶���ʹ������״̬
				updateOrderBillUseDisState(ctx,so.getId().toString(),true);
				
			}
		}
		
	}
	
	
	/**
	 * �����ʱִ��ҵ����
	 * @param ctx
	 * @param pk
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void afterUnAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
		// ������δ��Ч ��ִ�д��룬����ִ�У����dep���ö�� ����
		if(so.getBoolean("hasUseDis")){
			BigDecimal useDis = so.getBigDecimal("useDis");
			if(useDis != null && useDis.compareTo(BigDecimal.ZERO) > 0){
				String companyID = so.getSaleOrgUnit().getId().toString();
				String customerID = so.getOrderCustomer().getId().toString();
				SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(companyID,customerID,null,useDis);
				// ���¶���ʹ������״̬
				updateOrderBillUseDisState(ctx,so.getId().toString(),false);
				
			}
		}
		
	}
	/**
	 * ���¶��� ��ʹ������ ״̬
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
	 * ���¿ͻ����
	 * @param ctx
	 * @param companyID
	 * @param customerID
	 * @param useDis
	 * @param addOrSub
	 * @throws BOSException 
	 */
	@Deprecated
	public void updateCustomerBalance(Context ctx,String companyID, String customerID,BigDecimal substractAmount, BigDecimal addAmount) throws BOSException{
		// ��˾���ͻ���Ϊ�� ͬʱ���ٺ����ӽ���ͬʱΪ��
		if(StringUtils.isNotBlank(companyID) &&
				StringUtils.isNotBlank(customerID) && !(
						substractAmount == null && addAmount == null) ){
			SaleDiscountFacadeFactory.getLocalInstance(ctx).updateCustomerBalance(companyID, customerID, substractAmount, addAmount);
		}
	}
	
	
	/**
	 * ��ͬ������ʱ��̨ �����������ͬ�Ĺ�����ϵ
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void addSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
		// ������δ��Ч ��ִ�д��룬����ִ�У����dep���ö�� ����
		if(so.getObjectValue("saleContract") != null){
			SaleContractInfo contractInfo = (SaleContractInfo) so.getObjectValue("saleContract");
			
			String destBostype = so.getBOSType().toString();
			String destObjectID = pk.toString();
			String srcBostype = contractInfo.getBOSType().toString();
			String srcObjectID = contractInfo.getId().toString();
			// ��ӹ�����ϵ�����ݿ�
			BotpAppCommon.addRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
		}
		
	}
	

	/**
	 * ɾ�������� ���ۺ�ͬ��Ĺ�����ϵ 
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void removeSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

//		SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
//		// ������δ��Ч ��ִ�д��룬����ִ�У����dep���ö�� ����
//		if(so.getObjectValue("saleContract") != null){
//			SaleContractInfo contractInfo = (SaleContractInfo) so.getObjectValue("saleContract");
			if(pk != null){
				String destBostype = SaleOrderFactory.getLocalInstance(ctx).getType().toString();
				String destObjectID = pk.toString();
				String srcBostype = SaleContractFactory.getLocalInstance(ctx).getType().toString();
				String srcObjectID = "";
				// ��ӹ�����ϵ�����ݿ�
				BotpAppCommon.removeRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
			}
//		}
		
	}
}
