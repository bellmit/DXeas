package com.kingdee.eas.custom.signwasthetable.depPlugin;



public class PayBillControllerBeanDepPlugin {
//	/**
//	 * f=付款单反写合同
//	 * @param ctx
//	 * @param model
//	 * @return
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 */
//	public Boolean afterPaymentReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//付款按当前阶段、下一阶段顺延
//		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
//		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
//		for(int i=0;i<paymentEntry.size();i++)
//		{
//			String payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
//			StringBuffer buffer=new StringBuffer();
//			buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractManagePayment t3 ");
//			buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
//			buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
//			buffer.append(" where t1.fid='").append(payReqEntryID).append("'");
//			IRowSet rs=SQLExecutorFactory.getLocalInstance(ctx, buffer.toString()).executeSQL();
//			String cmpEntryID="";
//			String cmpid="";
//			try {
//				if(rs.next())
//				{
//					cmpEntryID=rs.getString("fparentid");
//					cmpid=rs.getString("fid");
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//获取合同签呈的info和分录的集合
//			ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(cmpid));
//			ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(cmpEntryID));		
//
//			ContractManagePaymentCollection cmpEntry=cmInfo.getPayment();
//			BigDecimal overflow=paymentEntry.get(i).getAmount();
//			for(int j=cmpInfo.getSeq()-1;j<cmpEntry.size();j++)
//			{
//				ContractManagePaymentPayInfoCollection cmppEntry=cmpEntry.get(j).getPayInfo();
//				ContractManagePaymentPayInfoInfo cmppInfo=new ContractManagePaymentPayInfoInfo();
//				cmppInfo.setPhaseID(cmpEntry.get(j).getId().toString());
//				cmppInfo.setPhaseCoding(cmpEntry.get(j).getPhaseCoding());
//				cmppInfo.setPayBillId(info.getId().toString());
//				cmppInfo.setPayDate(info.getBizDate());
//				cmppInfo.setPayAmount(paymentEntry.get(i).getAmount());
//				cmppInfo.setPayAmountLocal(cmppInfo.getPayAmount().multiply(info.getExchangeRate()));
//
//				if(cmpEntry.get(j).getPayedAmount()==null)
//					cmpEntry.get(j).setPayedAmount(new BigDecimal("0"));
//				BigDecimal totalAmount=cmpEntry.get(j).getPayedAmount().add(overflow);
//				BigDecimal minus=totalAmount.subtract(cmpEntry.get(j).getPayAmount());
//				if((minus.compareTo(BigDecimal.ZERO))<=0)
//				{
//					cmpEntry.get(j).setPayedAmount(totalAmount);
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(cmpEntry.get(j).getPayAmount().subtract(cmpEntry.get(j).getPayedAmount()));
//					cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//					cmppInfo.setUnOverFlow(overflow);
//					cmppEntry.add(cmppInfo);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					break;
//				}
//				else
//				{
//					if(j==cmpEntry.size()-1)
//					{
//						cmppInfo.setUnOverFlow(overflow);
//						cmpEntry.get(j).setPayedAmount(totalAmount);
//						cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//						cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO.subtract(minus));
//						cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//						cmppEntry.add(cmppInfo);
//						ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//						break;
//					}
//					cmppInfo.setUnOverFlow(totalAmount.subtract(minus));
//					cmpEntry.get(j).setPayedAmount(cmpEntry.get(j).getPayAmount());
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO);
//					cmpEntry.get(j).setPayingAmountLocalCurrency(BigDecimal.ZERO);	
//					cmppEntry.add(cmppInfo);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					overflow=overflow.subtract(minus);
//				}
//			}
//			
//			
//			
//			for(int j=0;j<cmpEntry.size();j++)
//			{
//				if(cmpEntry.get(j).getPayedAmount()!=null)
//					if((cmpEntry.get(j).getPayedAmount().compareTo(BigDecimal.ZERO))==0)
//					{
//						cmpEntry.get(j).setPayedAmount(null);
//						cmpEntry.get(j).setPayedAmountLocalCurrency(null);
//					}
//				ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//			}
//		}		
//		return true;
//	} 
//	public Boolean afterUnPayReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//反付款2
//		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
//		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的整个分录		
//		String payReqEntryID=paymentEntry.get(0).getSourceBillEntryId();//修改将i改为0
//		StringBuffer buffer=new StringBuffer();
//		buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractManagePayment t3 ");
//		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
//		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
//		buffer.append(" where t1.fid='").append(payReqEntryID).append("'");
//		IRowSet rs=SQLExecutorFactory.getLocalInstance(ctx, buffer.toString()).executeSQL();
//		String cmpEntryID="";
//		String cmpid="";
//		try {
//			if(rs.next())
//			{
//				cmpEntryID=rs.getString("fparentid");
//				cmpid=rs.getString("fid");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(cmpid));
//		ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(cmpEntryID));		
//
//		ContractManagePaymentCollection cmpEntry=cmInfo.getPayment();
//		for(int j=cmpInfo.getSeq()-1;j<cmpEntry.size();j++)
//		{
//			ContractManagePaymentPayInfoCollection cmppEntry=cmpEntry.get(j).getPayInfo();
//			for(int k=cmppEntry.size()-1;k>=0;k--)
//			{
//				if(cmppEntry.get(k).getPayBillId()==null)
//					continue;
//				if(cmppEntry.get(k).getPayBillId().equals(info.getId().toString()))
//				{
//					cmpEntry.get(j).setPayedAmount(cmpEntry.get(j).getPayedAmount().subtract(cmppEntry.get(k).getUnOverFlow()));
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(cmpEntry.get(j).getPayingAmount().add(cmppEntry.get(k).getUnOverFlow()));
//					cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//					cmppEntry.remove(cmppEntry.get(k));
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//				}
//			}
//		}	
//		for(int j=0;j<cmpEntry.size();j++)
//		{
//			if(cmpEntry.get(j).getPayedAmount()!=null)
//				if((cmpEntry.get(j).getPayedAmount().compareTo(BigDecimal.ZERO))==0)
//				{
//					cmpEntry.get(j).setPayedAmount(null);
//					cmpEntry.get(j).setPayedAmountLocalCurrency(null);
//				}
//			ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//		}
//		return true;
//	} 
//	public Boolean afterPayment2ReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//付款按阶段1、2、3顺延
//		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
//		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
//		for(int i=0;i<paymentEntry.size();i++)
//		{
//			String payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
//			StringBuffer buffer=new StringBuffer();
//			buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractManagePayment t3 ");
//			buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
//			buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
//			buffer.append(" where t1.fid='").append(payReqEntryID).append("'");
//			IRowSet rs=SQLExecutorFactory.getLocalInstance(ctx, buffer.toString()).executeSQL();
//			String cmpEntryID="";
//			String cmpid="";
//			try {
//				if(rs.next())
//				{
//					cmpEntryID=rs.getString("fparentid");
//					cmpid=rs.getString("fid");
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(cmpid));
//			ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(cmpEntryID));
//			ContractManagePaymentCollection cmpEntry=cmInfo.getPayment();
//			BigDecimal overflow=paymentEntry.get(i).getAmount();
//			for(int j=0;j<cmpEntry.size();j++)
//			{
//				if(cmpEntry.get(j).getPayedAmount()==null)
//				{
//					cmpEntry.get(j).setPayedAmount(BigDecimal.ZERO);
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//				}
//				if(cmpEntry.get(j).getPayedAmount().equals(cmpEntry.get(j).getPayAmount()))//如果该阶段的付款金额已满，则进入下一个付款阶段
//					continue;
//				ContractManagePaymentPayInfoCollection cmppEntry=cmpEntry.get(j).getPayInfo();
//				ContractManagePaymentPayInfoInfo cmppInfo=new ContractManagePaymentPayInfoInfo();
//
//				cmppInfo.setPhaseID(cmpInfo.getId().toString());
//				cmppInfo.setPhaseCoding(cmpInfo.getPhaseCoding());//记录本应付款阶段的id和阶段编码
//				cmppInfo.setPayBillId(info.getId().toString());
//				cmppInfo.setPayDate(info.getBizDate());//记录付款单的id和业务日期
//				cmppInfo.setPayAmount(paymentEntry.get(i).getAmount());
//				cmppInfo.setPayAmountLocal(cmppInfo.getPayAmount().multiply(info.getExchangeRate()));
//
//				BigDecimal totalAmount=cmpEntry.get(j).getPayedAmount().add(overflow);
//				BigDecimal minus=totalAmount.subtract(cmpEntry.get(j).getPayAmount());
//				if((minus.compareTo(BigDecimal.ZERO))<=0)
//				{
//					cmpEntry.get(j).setPayedAmount(totalAmount);
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(cmpEntry.get(j).getPayAmount().subtract(cmpEntry.get(j).getPayedAmount()));
//					cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//					cmppInfo.setUnOverFlow(overflow);
//					cmppEntry.add(cmppInfo);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					break;
//				}
//				else
//				{
//					if(j==cmpEntry.size()-1)
//					{
//						cmppInfo.setUnOverFlow(overflow);
//						cmpEntry.get(j).setPayedAmount(totalAmount);
//						cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//						cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO.subtract(minus));
//						cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//						cmppEntry.add(cmppInfo);
//						ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//						break;
//					}
//					cmppInfo.setUnOverFlow(overflow.subtract(minus));
//					cmpEntry.get(j).setPayedAmount(cmpEntry.get(j).getPayAmount());
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO);
//					cmpEntry.get(j).setPayingAmountLocalCurrency(BigDecimal.ZERO);					
//					cmppEntry.add(cmppInfo);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					overflow=minus;
//				}
//			}
//			for(int j=0;j<cmpEntry.size();j++)
//			{
//				if(cmpEntry.get(j).getPayedAmount()!=null)
//					if((cmpEntry.get(j).getPayedAmount().compareTo(BigDecimal.ZERO))==0)
//					{
//						cmpEntry.get(j).setPayedAmount(null);
//						cmpEntry.get(j).setPayedAmountLocalCurrency(null);
//					}
//				ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//			}
//		}		
//		return true;
//	} 
//	public Boolean afterPayment3ReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException{//付款按当前阶段，1、2、3顺延
//		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
//		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
//		for(int i=0;i<paymentEntry.size();i++)
//		{
//			String payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
//			PayRequestBillEntryInfo payreqInfo=PayRequestBillEntryFactory.getLocalInstance(ctx).getPayRequestBillEntryInfo(new ObjectUuidPK(payReqEntryID));			  
//			String cmEntryID=payreqInfo.getSourceBillEntryid();
//			ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(cmEntryID));
//			//获取源合同关联分录
//			ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(cmpInfo.getParent().getId()));//获取原合同信息
//			ContractManagePaymentCollection cmpEntry=cmInfo.getPayment();
//			BigDecimal overflow=paymentEntry.get(i).getAmount();
//			int flag=cmpInfo.getSeq();
//			for(int j=cmpInfo.getSeq()-1;j<cmpEntry.size();j++)
//			{
//				if(cmpEntry.get(j).getPayedAmount().equals(null))
//				{
//					cmpEntry.get(j).setPayedAmount(BigDecimal.ZERO);
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//				}
//				if(cmpEntry.get(j).getPayedAmount().equals(cmpEntry.get(j).getPayAmount()))//如果该阶段的付款金额已满，则进入下一个付款阶段
//				{
//					if(flag==cmpInfo.getSeq())
//					{
//						flag=-1;
//						j=0;
//					}
//					continue;
//				}
//				ContractManagePaymentPayInfoCollection cmppEntry=cmpEntry.get(j).getPayInfo();
//				ContractManagePaymentPayInfoInfo cmppInfo=new ContractManagePaymentPayInfoInfo();
//
//				cmppInfo.setPhaseID(cmpInfo.getId().toString());
//				cmppInfo.setPhaseCoding(cmpInfo.getPhaseCoding());//记录本应付款阶段的id和阶段编码
//				cmppInfo.setPayBillId(info.getId().toString());
//				cmppInfo.setPayDate(info.getBizDate());//记录付款单的id和业务日期
//				cmppInfo.setPayAmount(paymentEntry.get(i).getAmount());
//				cmppInfo.setPayAmountLocal(cmppInfo.getPayAmount().multiply(info.getExchangeRate()));
//
//				BigDecimal totalAmount=cmpEntry.get(j).getPayedAmount().add(overflow);
//				BigDecimal minus=totalAmount.subtract(cmpEntry.get(j).getPayAmount());
//				if((minus.compareTo(BigDecimal.ZERO))<=0)
//				{
//					cmpEntry.get(j).setPayedAmount(totalAmount);
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayedAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(cmpEntry.get(j).getPayAmount().subtract(cmpEntry.get(j).getPayedAmount()));
//					cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//					cmppInfo.setUnOverFlow(overflow);
//					cmppEntry.add(cmppInfo);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					break;
//				}
//				else
//				{
//					if(j==cmpEntry.size()-1)
//					{
//						cmppInfo.setUnOverFlow(overflow);
//						cmpEntry.get(j).setPayedAmount(totalAmount);
//						cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//						cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO.subtract(minus));
//						cmpEntry.get(j).setPayingAmountLocalCurrency(cmpEntry.get(j).getPayingAmount().multiply(info.getExchangeRate()));
//						cmppEntry.add(cmppInfo);
//						ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//						break;
//					}
//					cmppInfo.setUnOverFlow(totalAmount.subtract(minus));
//					cmpEntry.get(j).setPayedAmount(cmpEntry.get(j).getPayAmount());
//					cmpEntry.get(j).setPayedAmountLocalCurrency(cmpEntry.get(j).getPayAmount().multiply(info.getExchangeRate()));
//					cmpEntry.get(j).setPayingAmount(BigDecimal.ZERO);
//					cmpEntry.get(j).setPayingAmountLocalCurrency(BigDecimal.ZERO);	
//					cmppEntry.add(cmppInfo);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(cmpEntry.get(j));
//					overflow=overflow.subtract(minus);
//					if(flag==cmpInfo.getSeq())
//					{
//						flag=-1;
//						j=0;
//					}
//				}
//			}
//		}		
//		return true;
//	}
	}
