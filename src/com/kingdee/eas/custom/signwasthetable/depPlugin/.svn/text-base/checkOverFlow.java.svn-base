package com.kingdee.eas.custom.signwasthetable.depPlugin;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ap.PayRequestBillEntryCollection;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.ap.client.PayRequestBillEditUI;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/*
 * 该方法用来校验提交付款申请后是否会超过限定的金额，超出后抛出异常，禁止提交
 */
public class checkOverFlow {
	protected PayRequestBillInfo info;
	/*
	 * 该校验作用于  提交和保存
	 * 付款申请单付款金额合法性校验
	 * 允许超额付款情况下 1.如果该阶段的累计申请付款金额超过范围，提示：超出超额比例，申请付款失败
	 * 不循序超额付款情况下：2.如果该阶段的累计申请付款金额超过范围，提示：超过付款金额，申请失败
	 */
	public void beforeSaveRewrite(Object ui) throws EASBizException, BOSException
	{
		//传入的是界面参数，获取付款申请的info和info的分录
		PayRequestBillEditUI editUI = (PayRequestBillEditUI)ui;
		info=(PayRequestBillInfo) editUI.getEditData();
		PayRequestBillEntryCollection entryInfos = info.getEntrys();
		KDTable kdtEntry = editUI.getTableForPrint();
//		KDTable kdtEntry = editUI.getEntryTable();
		// 如果用户删除了所有的分录，在提交时会提示“该记录已不存在”
		if(info.getId()==null)
		{
			throw new EASBizException(new NumericExceptionSubItem("001","该记录已不存在"));
		}
		//查询原合同签呈的信息
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractManagePayment t3 ");
		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
		buffer.append("where t1.fparentid='").append(info.getId().toString()).append("'");
		buffer.append(" and t1.fid='").append(entryInfos.get(0).getId().toString()).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		String entryInfosCMID="";
		try {
			if(rs.next())
			{
				entryInfosCMID=rs.getString("fparentid");
				rs.getString("fid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();				
		}
		//原合同签呈及其分录
//		ContractManageInfo cmInfo=ContractManageFactory.getRemoteInstance().getContractManageInfo(new ObjectUuidPK(entryInfosCMID));
//		ContractManagePaymentCollection entryInfosCM=cmInfo.getPayment();
		
		
		
		/**
		 * 注释内容：付款申请单提交时，累计付款金额不允许超过 合同签订的金额
		 * 2015-11-14
		 */
//		BigDecimal AmtC=BigDecimal.ZERO;
//		//获得 合同签呈的已付款金额之和
//		for(int i=0;i<entryInfosCM.size();i++)
//			AmtC = AmtC.add(entryInfosCM.get(i).getPayAmount());
//		//获得付款申请单提交时的累计提交金额并与Amtc求和
//		for(int i=0;i<kdtEntry.getRowCount();i++)
//			AmtC=AmtC.add((BigDecimal) kdtEntry.getRow(i).getCell("auditAmount").getValue());
//		if(AmtC.compareTo(cmInfo.getAmountOriCurrency())!=-1)
//			throw new EASBizException(new NumericExceptionSubItem("001","累计申请付款金额超过合同总金额，付款失败"));
		
		
//		//审批金额
//		BigDecimal overflow=BigDecimal.ZERO;
//		for(int i=0;i<kdtEntry.getRowCount();i++)
//		{
//			for(int j=0;j<entryInfosCM.size();j++)
//			{
//				//如果付款申请表格行A的阶段编码和合同分录B编码相同（即A由B生成）
//				if(Integer.valueOf(String.valueOf(kdtEntry.getRow(i).getCell(0).getValue()))==entryInfosCM.get(j).getPhaseCoding())
//				{
//					//获取付款申请单上的审批金额
//					overflow=(BigDecimal) kdtEntry.getRow(i).getCell("auditAmount").getValue();
//					if(entryInfosCM.get(j).getRequiredPayAmount()==null)
//					{
//						entryInfosCM.get(j).setRequiredPayAmount(new BigDecimal("0"));
//						entryInfosCM.get(j).setReqPayAmountLocalCurrency(BigDecimal.ZERO);
//					}
//					//审批金额与该原单对应阶段的已申请付款金额之和
//					BigDecimal totalAmount=entryInfosCM.get(j).getRequiredPayAmount().add(overflow);
//					//如果合同阶段可以溢出且允许溢出的比率不为空
//					if(cmInfo.getBoolean("overFlow")&&entryInfosCM.get(j).getOverRate()!=null)
//					{
//						//允许超额的最大金额
//						BigDecimal overAmt = entryInfosCM.get(j).getPayAmount().multiply(entryInfosCM.get(j).getOverRate()).divide(new BigDecimal("100"),6,BigDecimal.ROUND_HALF_EVEN);
//						BigDecimal sumAmt = entryInfosCM.get(j).getPayAmount().add(overAmt);
//						//比较，若超出了允超金额，抛出异常
//						int compare=totalAmount.compareTo(sumAmt);
//						if(compare==1)						
//							throw new EASBizException(new NumericExceptionSubItem("001","超出付款金额的超额比例，申请付款失败"));
//					}
//					else
//					{
//						int compare=totalAmount.compareTo(entryInfosCM.get(j).getPayAmount());
//						if(compare==1)
//							throw new EASBizException(new NumericExceptionSubItem("001","超出付款金额，申请付款失败"));
//					}
//					break;
//				}
//			}
//		}
	}
}
