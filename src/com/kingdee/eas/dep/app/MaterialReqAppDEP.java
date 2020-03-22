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
 * ���ϳ��ⵥ DEP��̨��չ
 * @author USER
 *
 */
public class MaterialReqAppDEP {
	
	
	/**
	 * ��ת�����ϳ��⣨��ģ� 
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void addSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		MaterialReqBillInfo so = MaterialReqBillFactory.getLocalInstance(ctx).getMaterialReqBillInfo(pk);
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
	 * ɾ�����ϳ����� ���ۺ�ͬ��Ĺ�����ϵ 
	 * 
	 * @param ctx 
	 * @param pk 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void removeSaleContractRelation(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

//		MaterialReqBillInfo so = MaterialReqBillFactory.getLocalInstance(ctx).getMaterialReqBillInfo(pk);
//		// ������δ��Ч ��ִ�д��룬����ִ�У����dep���ö�� ����
//		if(so.getObjectValue("saleContract") != null){
//			SaleContractInfo contractInfo = (SaleContractInfo) so.getObjectValue("saleContract");
		if(pk!= null){
			String srcBostype = SaleContractFactory.getLocalInstance(ctx).getType().toString();
			String srcObjectID = "";
			String destBostype = MaterialReqBillFactory.getLocalInstance(ctx).getType().toString();
			String destObjectID = pk.toString();
			// ��ӹ�����ϵ�����ݿ�
			BotpAppCommon.removeRelations(ctx, srcBostype, srcObjectID, destBostype, destObjectID);
		}
		
	}
}
