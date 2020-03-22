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
import com.kingdee.eas.fi.ap.PayRequestBillEntryFactory;
import com.kingdee.eas.fi.ap.PayRequestBillEntryInfo;
import com.kingdee.eas.fi.cas.PaymentBillEntryCollection;
import com.kingdee.eas.fi.cas.PaymentBillFactory;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class payBillRelation {


	/**
	 * f=付款单反写合同
	 * @param ctx
	 * @param model
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public Boolean afterPaymentReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//付款按当前阶段、下一阶段顺延
		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
		
		String payreqBillID = checkOverFlow.getSrcBillIDByPayReqBill(ctx,info.getId().toString(),"D001019A");
		if(payreqBillID==null)
			return false;
		String contractID=checkOverFlow.getSrcBillIDByPayReqBill(ctx,payreqBillID,"8C0AA21C");
		if(contractID==null)
			return false;
		ContractInfo contractInfo = ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(contractID));
		if(contractInfo==null)
			return false;
		
		String payReqEntryID=null;
		String contractEntryID=null;
		ContractPaymentInfo contractPayInfo=null;
		for(int i=0;i<paymentEntry.size();i++)
		{
			payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
			if(payReqEntryID==null)
				return false;
			contractEntryID=checkOverFlow.getSrcEntryIDByPayReqBillEntryID(ctx, payReqEntryID);
			if(contractEntryID==null)
				return false;
			contractPayInfo = ContractPaymentFactory.getLocalInstance(ctx).getContractPaymentInfo(new ObjectUuidPK(contractEntryID));
			
			
			contractPayInfo.setPayedAmount(contractPayInfo.getPayedAmount().add(paymentEntry.get(i).getAmount()));
			contractPayInfo.setPayingAmount(contractPayInfo.getPayingAmount().subtract(paymentEntry.get(i).getAmount()));
			
			contractPayInfo.setPayedAmountLocal(contractPayInfo.getPayedAmount().multiply(contractInfo.getExchangeRate()));
			contractPayInfo.setPayingAmountLocal(contractPayInfo.getPayingAmount().multiply(contractInfo.getExchangeRate()));
			ContractPaymentFactory.getLocalInstance(ctx).save(contractPayInfo);
		}		
		return true;
	} 
	public Boolean afterUnPayReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//反付款2
		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
		
		String payreqBillID = checkOverFlow.getSrcBillIDByPayReqBill(ctx,info.getId().toString(),"D001019A");
		if(payreqBillID==null)
			return false;
		String contractID=checkOverFlow.getSrcBillIDByPayReqBill(ctx,payreqBillID,"8C0AA21C");
		if(contractID==null)
			return false;
		ContractInfo contractInfo = ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(contractID));
		if(contractInfo==null)
			return false;
		
		String payReqEntryID=null;
		String contractEntryID=null;
		ContractPaymentInfo contractPayInfo=null;
		for(int i=0;i<paymentEntry.size();i++)
		{
			payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
			contractEntryID=checkOverFlow.getSrcEntryIDByPayReqBillEntryID(ctx, payReqEntryID);
			contractPayInfo = ContractPaymentFactory.getLocalInstance(ctx).getContractPaymentInfo(new ObjectUuidPK(contractEntryID));
			
			
			contractPayInfo.setPayedAmount(contractPayInfo.getPayedAmount().subtract(paymentEntry.get(i).getAmount()));
			contractPayInfo.setPayingAmount(contractPayInfo.getPayingAmount().add(paymentEntry.get(i).getAmount()));
			
			contractPayInfo.setPayedAmountLocal(contractPayInfo.getPayedAmount().multiply(contractInfo.getExchangeRate()));
			contractPayInfo.setPayingAmountLocal(contractPayInfo.getPayingAmount().multiply(contractInfo.getExchangeRate()));
			ContractPaymentFactory.getLocalInstance(ctx).save(contractPayInfo);
		}		
		return true;
	} 
	public Boolean afterPayment2ReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//付款按阶段1、2、3顺延
		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
		for(int i=0;i<paymentEntry.size();i++)
		{
			String payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
			StringBuffer buffer=new StringBuffer();
			buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractPayment t3 ");
			buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
			buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
			buffer.append(" where t1.fid='").append(payReqEntryID).append("'");
			IRowSet rs=SQLExecutorFactory.getLocalInstance(ctx, buffer.toString()).executeSQL();
			String cmpEntryID="";
			String cmpid="";
			try {
				if(rs.next())
				{
					cmpEntryID=rs.getString("fparentid");
					cmpid=rs.getString("fid");
				}
				else
					return false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ContractPaymentInfo cmpInfo=ContractPaymentFactory.getLocalInstance(ctx).getContractPaymentInfo(new ObjectUuidPK(cmpid));
			ContractInfo cmInfo=ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(cmpEntryID));
			ContractPaymentCollection cmpEntry=cmInfo.getPayment();
			BigDecimal overflow=paymentEntry.get(i).getAmount();
			for(int j=0;j<cmpEntry.size();j++)
			{
				if(cmpEntry.get(j).getPayedAmount()==null)
				{
					cmpEntry.get(j).setPayedAmount(BigDecimal.ZERO);
					cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
				}
				if(cmpEntry.get(j).getPayedAmount().equals(cmpEntry.get(j).getPayAmount()))//如果该阶段的付款金额已满，则进入下一个付款阶段
					continue;
				ContractPaymentPayInfoCollection cmppEntry=cmpEntry.get(j).getPayInfo();
				ContractPaymentPayInfoInfo cmppInfo=new ContractPaymentPayInfoInfo();

				cmppInfo.setPhaseID(cmpInfo.getId().toString());
				cmppInfo.setPhaseCoding(cmpInfo.getPhaseCoding());//记录本应付款阶段的id和阶段编码
				cmppInfo.setPayBillId(info.getId().toString());
				cmppInfo.setPayDate(info.getBizDate());//记录付款单的id和业务日期
				cmppInfo.setPayAmount(paymentEntry.get(i).getAmount());
				cmppInfo.setPayAmountLocal(cmppInfo.getPayAmount().multiply(info.getExchangeRate()));

				BigDecimal totalAmount=cmpEntry.get(j).getPayedAmount().add(overflow);
//				BigDecimal minus=totalAmount.subtract(cmpEntry.get(j).getOverAmt());
//				if((minus.compareTo(BigDecimal.ZERO))<=0)
//				{
//					cmpEntry.get(j).setPayedAmount(totalAmount);
//					cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(cmpEntry.get(j).getRequiredPayAmount().subtract(cmpEntry.get(j).getPayedAmount()));
//					cmpEntry.get(j).setPayingAmountLocal(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//					cmppInfo.setUnOverFlow(overflow);
//					cmppEntry.add(cmppInfo);
//					ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					break;
//				}
//				else
//				{
//					if(j==cmpEntry.size()-1)
//					{
//						cmppInfo.setUnOverFlow(overflow);
//						cmpEntry.get(j).setPayedAmount(totalAmount);
//						cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//						cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO.subtract(minus));
//						cmpEntry.get(j).setPayingAmountLocal(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//						cmppEntry.add(cmppInfo);
//						ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//						break;
//					}
//					cmppInfo.setUnOverFlow(overflow.subtract(minus));
//					cmpEntry.get(j).setPayedAmount(cmpEntry.get(j).getPayAmount());
//					cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO);
//					cmpEntry.get(j).setPayingAmountLocal(BigDecimal.ZERO);					
//					cmppEntry.add(cmppInfo);
//					ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					overflow=minus;
//				}
			}
			for(int j=0;j<cmpEntry.size();j++)
			{
				if(cmpEntry.get(j).getPayedAmount()!=null)
					if((cmpEntry.get(j).getPayedAmount().compareTo(BigDecimal.ZERO))==0)
					{
						cmpEntry.get(j).setPayedAmount(null);
						cmpEntry.get(j).setPayedAmountLocal(null);
					}
				if(cmpEntry.get(j).getPayingAmount()!=null)
					if(cmpEntry.get(j).getPayingAmount().equals(BigDecimal.ZERO))
					{
						cmpEntry.get(j).setPayingAmount(null);
						cmpEntry.get(j).setPayingAmountLocal(null);
					}
				ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
			}
		}		
		return true;
	} 
	public Boolean afterPayment3ReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//付款按当前阶段，1、2、3顺延
		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
		for(int i=0;i<paymentEntry.size();i++)
		{
			String payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
			PayRequestBillEntryInfo payreqInfo=PayRequestBillEntryFactory.getLocalInstance(ctx).getPayRequestBillEntryInfo(new ObjectUuidPK(payReqEntryID));			  
			String cmEntryID=payreqInfo.getSourceBillEntryid();
			ContractPaymentInfo cmpInfo=ContractPaymentFactory.getLocalInstance(ctx).getContractPaymentInfo(new ObjectUuidPK(cmEntryID));
			//获取源合同关联分录
			ContractInfo cmInfo=ContractFactory.getLocalInstance(ctx).getContractInfo(new ObjectUuidPK(cmpInfo.getParent().getId()));//获取原合同信息
			ContractPaymentCollection cmpEntry=cmInfo.getPayment();
			BigDecimal overflow=paymentEntry.get(i).getAmount();
			int flag=cmpInfo.getSeq();
			for(int j=cmpInfo.getSeq()-1;j<cmpEntry.size();j++)
			{
				if(cmpEntry.get(j).getPayedAmount().equals(null))
				{
					cmpEntry.get(j).setPayedAmount(BigDecimal.ZERO);
					cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
				}
				if(cmpEntry.get(j).getPayedAmount().equals(cmpEntry.get(j).getPayAmount()))//如果该阶段的付款金额已满，则进入下一个付款阶段
				{
					if(flag==cmpInfo.getSeq())
					{
						flag=-1;
						j=0;
					}
					continue;
				}
				ContractPaymentPayInfoCollection cmppEntry=cmpEntry.get(j).getPayInfo();
				ContractPaymentPayInfoInfo cmppInfo=new ContractPaymentPayInfoInfo();

				cmppInfo.setPhaseID(cmpInfo.getId().toString());
				cmppInfo.setPhaseCoding(cmpInfo.getPhaseCoding());//记录本应付款阶段的id和阶段编码
				cmppInfo.setPayBillId(info.getId().toString());
				cmppInfo.setPayDate(info.getBizDate());//记录付款单的id和业务日期
				cmppInfo.setPayAmount(paymentEntry.get(i).getAmount());
				cmppInfo.setPayAmountLocal(cmppInfo.getPayAmount().multiply(info.getExchangeRate()));

				BigDecimal totalAmount=cmpEntry.get(j).getPayedAmount().add(overflow);
				BigDecimal minus=totalAmount.subtract(cmpEntry.get(j).getPayAmount());
				if((minus.compareTo(BigDecimal.ZERO))<=0)
				{
					cmpEntry.get(j).setPayedAmount(totalAmount);
					cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
					cmpEntry.get(j).setPayingAmount(cmpEntry.get(j).getPayAmount().subtract(cmpEntry.get(j).getPayedAmount()));
					cmpEntry.get(j).setPayingAmountLocal(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
					cmppInfo.setUnOverFlow(overflow);
					cmppEntry.add(cmppInfo);
					ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
					break;
				}
				else
				{
					if(j==cmpEntry.size()-1)
					{
						cmppInfo.setUnOverFlow(overflow);
						cmpEntry.get(j).setPayedAmount(totalAmount);
						cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
						cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO.subtract(minus));
						cmpEntry.get(j).setPayingAmountLocal(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
						cmppEntry.add(cmppInfo);
						ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
						break;
					}
					cmppInfo.setUnOverFlow(totalAmount.subtract(minus));
					cmpEntry.get(j).setPayedAmount(cmpEntry.get(j).getPayAmount());
					cmpEntry.get(j).setPayedAmountLocal(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
					cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO);
					cmpEntry.get(j).setPayingAmountLocal(BigDecimal.ZERO);	
					cmppEntry.add(cmppInfo);
					ContractPaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
					overflow=overflow.subtract(minus);
					if(flag==cmpInfo.getSeq())
					{
						flag=-1;
						j=0;
					}
				}
			}
		}		
		return true;
	} 
}
