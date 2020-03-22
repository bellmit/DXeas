package com.kingdee.eas.custom.signwasthetable.depPlugin;

/**
 * 付款申请dep调用插件
 * @author shoot
 *
 */
public class PayRequestBillControllerBeanDepPlugin {
//
//	/**
//	 * f=付款申请反写合同
//	 * @param ctx
//	 * @param model
//	 * @return
//	 * @throws BOSException 
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 * @throws EASBizException 
//	 */
//	public void  afterAuditRewriteConstantByID(Context ctx, String id) throws BOSException, EASBizException //溢出情况下付款申请执行当前阶段、下一阶段
//	{
//		//或的付款申请单的info和分录的集合
//		PayRequestBillInfo info=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(id));
//		PayRequestBillEntryCollection entryInfos = info.getEntrys();
//		
//		
//		//获得源单的id和源单对应的分录的id
//		for(int i=0;i<entryInfos.size();i++)
//		{
//			StringBuffer buffer=new StringBuffer();
//			buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractManagePayment t3 ");
//			buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
//			buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
//			buffer.append("where t1.fparentid='").append(id).append("'");
//			buffer.append(" and t1.fid='").append(entryInfos.get(i).getId().toString()).append("'");
//			IRowSet rs=SQLExecutorFactory.getLocalInstance(ctx, buffer.toString()).executeSQL();
//			String entryInfosCMID="";
//			String cmpid="";
//			try {
//				if(rs.next())
//				{
//					entryInfosCMID=rs.getString("fparentid");
//					cmpid=rs.getString("fid");
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();				
//			}
//			
//			
//			//根据获得的id获得对应的info
//			ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(cmpid));
//			ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(entryInfosCMID));
//			ContractManagePaymentCollection entryInfosCM=cmInfo.getPayment();
//			BigDecimal overflow=entryInfos.get(i).getAuditAmount();
//			int j=cmpInfo.getSeq()-1;
//			if(entryInfosCM.get(j).getRequiredPayAmount()==null)
//			{
//				entryInfosCM.get(j).setRequiredPayAmount(new BigDecimal("0"));
//				entryInfosCM.get(j).setReqPayAmountLocalCurrency(BigDecimal.ZERO);
//			}
//			BigDecimal totalAmount=entryInfosCM.get(j).getRequiredPayAmount().add(overflow);
//
//
////			totalAmount.subtract(entryInfosCM.get(j).getPayAmount());
//			//如果源单允许超额付款且允超比例不为空
//			if(cmInfo.getBoolean("overFlow")&&entryInfosCM.get(j).getOverRate()!=null)
//			{
//				BigDecimal overAmt = entryInfosCM.get(j).getPayAmount().multiply(entryInfosCM.get(j).getOverRate()).divide(new BigDecimal("100"),6,BigDecimal.ROUND_HALF_EVEN);
//				BigDecimal sumAmt = entryInfosCM.get(j).getPayAmount().add(overAmt);
//				int compare=totalAmount.compareTo(sumAmt);
//				if(compare==1)
//					throw new EASBizException(new NumericExceptionSubItem("001","超出付款金额的超额比例，申请付款失败"));
//			}
//			else
//			{
//				int compare=totalAmount.compareTo(entryInfosCM.get(j).getPayAmount());
//				if(compare==1)	
//					throw new EASBizException(new NumericExceptionSubItem("001","超出付款金额，申请付款失败"));
//			}
//			ContractManagePaymentPayInfoCollection cmppEntry=entryInfosCM.get(j).getPayInfo();
//			ContractManagePaymentPayInfoInfo cmppInfo=new ContractManagePaymentPayInfoInfo();
//
//			cmppInfo.setPayDate(info.getBizDate());
//			cmppInfo.setPayReqBillID(info.getId().toString());
//			cmppInfo.setPayReqBillreqAmt(entryInfos.get(i).getAuditAmount());
//			cmppInfo.setPhaseID(cmpInfo.getId().toString());
//			cmppInfo.setUnOverFlow(overflow);
//			//修改申请付款金额和本位币
//			entryInfosCM.get(j).setRequiredPayAmount(totalAmount);
//			entryInfosCM.get(j).setReqPayAmountLocalCurrency(entryInfosCM.get(j).getRequiredPayAmount().multiply(info.getExchange_rate()));
//			
//			
//			
//			
//			//修改未付款金额和本位币
//			if((entryInfosCM.get(j).getRequiredPayAmount().compareTo(entryInfosCM.get(j).getPayAmount()))==1)//如果申请付款金额大于付款金额
//			{
//				//则未付款金额=申请付款金额-已付款金额
//				if(entryInfosCM.get(j).getPayedAmount()==null)
//					entryInfosCM.get(j).setPayedAmount(BigDecimal.ZERO);
//				entryInfosCM.get(j).setPayingAmount(entryInfosCM.get(j).getRequiredPayAmount().subtract(entryInfosCM.get(j).getPayedAmount()));
//				entryInfosCM.get(j).setPayingAmountLocalCurrency(entryInfosCM.get(j).getPayingAmount().multiply(info.getExchange_rate()));
//				if(entryInfosCM.get(j).getPayedAmount().equals(BigDecimal.ZERO))
//					entryInfosCM.get(j).setPayedAmount(null);
//			}
//			cmppEntry.add(cmppInfo);
//			ContractManagePaymentFactory.getLocalInstance(ctx).save(entryInfosCM.get(j));
//		}
//	}
//	public Boolean afterUnAuditReWriteConstanceByID(Context ctx,String id) throws EASBizException, BOSException//付款申请的反审核2
//	{
//		PayRequestBillInfo info=PayRequestBillFactory.getLocalInstance(ctx).getPayRequestBillInfo(new ObjectUuidPK(id));
//		StringBuffer buffer=new StringBuffer();
//		buffer.append("select t3.fid from T_SIG_ContractManagePayment t3 ");
//		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
//		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
//		buffer.append("where t1.fparentid='").append(id).append("'");
//		IRowSet rs=SQLExecutorFactory.getLocalInstance(ctx, buffer.toString()).executeSQL();
//		String entryInfosCMID="";
//		try {
//			if(rs.next())
//				entryInfosCMID=rs.getString("fid");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(entryInfosCMID));
//		//获取源合同关联分录				
//		ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(cmpInfo.getParent().getId()));
//		//获取原合同信息
//		ContractManagePaymentCollection entryInfosCM=cmInfo.getPayment();
//		for(int j=0;j<entryInfosCM.size();j++)
//		{
//			ContractManagePaymentPayInfoCollection cmppEntry=entryInfosCM.get(j).getPayInfo();
//			for(int k=cmppEntry.size()-1;k>=0;k--)
//			{
//				if(cmppEntry.get(k).getPayReqBillID()==null)
//					continue;					
//				if(cmppEntry.get(k).getPayReqBillID().equals(info.getId().toString()))
//				{
//					entryInfosCM.get(j).setRequiredPayAmount(entryInfosCM.get(j).getRequiredPayAmount().subtract(cmppEntry.get(k).getUnOverFlow()));
//					entryInfosCM.get(j).setReqPayAmountLocalCurrency(entryInfosCM.get(j).getRequiredPayAmount().multiply(info.getExchange_rate()));
//					cmppEntry.remove(cmppEntry.get(k));
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(entryInfosCM.get(j));						
//				}
//			}
//		}
//		for(int j=0;j<entryInfosCM.size();j++)
//		{
//			if(entryInfosCM.get(j).getRequiredPayAmount()!=null)
//				if((entryInfosCM.get(j).getRequiredPayAmount().compareTo(BigDecimal.ZERO))==0)
//				{
//					entryInfosCM.get(j).setRequiredPayAmount(null);
//					entryInfosCM.get(j).setReqPayAmountLocalCurrency(null);
//					ContractManagePaymentFactory.getLocalInstance(ctx).save(entryInfosCM.get(j));
//				}
//		}
//		return true;
//	} 

}
