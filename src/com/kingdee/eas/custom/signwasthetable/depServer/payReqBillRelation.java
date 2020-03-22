package com.kingdee.eas.custom.signwasthetable.depServer;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentFactory;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoInfo;
import com.kingdee.eas.custom.signwasthetable.depClient.checkOverFlow;
import com.kingdee.eas.fi.ap.PayRequestBillEntryCollection;
import com.kingdee.eas.fi.ap.PayRequestBillFactory;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class payReqBillRelation {
	/**
	 * f=�������뷴д��ͬ
	 * @param ctx
	 * @param model
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public boolean  afterAuditRewriteConstantByID(Context ctx, String id) throws BOSException, EASBizException //�������¸�������ִ�е�ǰ�׶Ρ���һ�׶�
	{
		if(id==null||id.equals(""))
			return false;
		
		PayRequestBillInfo info=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(id));
		PayRequestBillEntryCollection entryInfos = info.getEntrys();
		String cotractID = checkOverFlow.getSrcBillIDByPayReqBill(ctx,info.getId().toString(),"8C0AA21C");
		if(cotractID==null)
			return false;
		ContractInfo contactInfo = ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(cotractID));

		String cmpid;
		ContractPaymentInfo cmpInfo;
		for(int i=0;i<entryInfos.size();i++)
		{
			cmpid = checkOverFlow.getSrcEntryIDByPayReqBillEntryID(ctx,entryInfos.get(i).getId().toString());
			cmpInfo=ContractPaymentFactory.getLocalInstance(ctx).getContractPaymentInfo(new ObjectUuidPK(cmpid));


			cmpInfo.setRequiredPayAmount(cmpInfo.getRequiredPayAmount().add(entryInfos.get(i).getAuditAmount()));//�����븶����
			cmpInfo.setUnRequiredAmt(cmpInfo.getUnRequiredAmt().subtract(entryInfos.get(i).getAuditAmount()));//δ���븶����
			cmpInfo.setPayingAmount(cmpInfo.getRequiredPayAmount().subtract(cmpInfo.getPayedAmount()));//δ������
			
			cmpInfo.setReqPayAmountLocal(cmpInfo.getRequiredPayAmount().multiply(contactInfo.getExchangeRate()));
			cmpInfo.setUnReqAmtLocal(cmpInfo.getUnRequiredAmt().multiply(contactInfo.getExchangeRate()));
			cmpInfo.setPayingAmountLocal(cmpInfo.getPayingAmount().multiply(contactInfo.getExchangeRate()));
			
			ContractPaymentFactory.getLocalInstance(ctx).save(cmpInfo);


		}
		return true;

	}
	public Boolean afterUnAuditReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//��������ķ����2
		if(id==null||id.equals(""))
			return false;
		
		PayRequestBillInfo info=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(id));
		PayRequestBillEntryCollection entryInfos = info.getEntrys();
		String cotractID = checkOverFlow.getSrcBillIDByPayReqBill(ctx,info.getId().toString(),"8C0AA21C");
		if(cotractID==null)
			return false;
		ContractInfo contactInfo = ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(cotractID));

		String cmpid;
		ContractPaymentInfo cmpInfo;
		for(int i=0;i<entryInfos.size();i++)
		{
			cmpid = checkOverFlow.getSrcEntryIDByPayReqBillEntryID(ctx,entryInfos.get(i).getId().toString());
			cmpInfo=ContractPaymentFactory.getLocalInstance(ctx).getContractPaymentInfo(new ObjectUuidPK(cmpid));


			cmpInfo.setRequiredPayAmount(cmpInfo.getRequiredPayAmount().subtract(entryInfos.get(i).getAuditAmount()));//�����븶����
			cmpInfo.setUnRequiredAmt(cmpInfo.getUnRequiredAmt().add(entryInfos.get(i).getAuditAmount()));//δ���븶����
			cmpInfo.setPayingAmount(cmpInfo.getRequiredPayAmount().add(cmpInfo.getPayedAmount()));//δ������
			
			cmpInfo.setReqPayAmountLocal(cmpInfo.getRequiredPayAmount().multiply(contactInfo.getExchangeRate()));
			cmpInfo.setUnReqAmtLocal(cmpInfo.getUnRequiredAmt().multiply(contactInfo.getExchangeRate()));
			cmpInfo.setPayingAmountLocal(cmpInfo.getPayingAmount().multiply(contactInfo.getExchangeRate()));
			
			ContractPaymentFactory.getLocalInstance(ctx).save(cmpInfo);


		}
		return true;
	} 

}
