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
 * �÷�������У���ύ����������Ƿ�ᳬ���޶��Ľ��������׳��쳣����ֹ�ύ
 */
public class checkOverFlow {
	protected PayRequestBillInfo info;
	/*
	 * ��У��������  �ύ�ͱ���
	 * �������뵥������Ϸ���У��
	 * ������������ 1.����ý׶ε��ۼ����븶�������Χ����ʾ������������������븶��ʧ��
	 * ��ѭ�򳬶������£�2.����ý׶ε��ۼ����븶�������Χ����ʾ���������������ʧ��
	 */
	public void beforeSaveRewrite(Object ui) throws EASBizException, BOSException
	{
		//������ǽ����������ȡ���������info��info�ķ�¼
		PayRequestBillEditUI editUI = (PayRequestBillEditUI)ui;
		info=(PayRequestBillInfo) editUI.getEditData();
		PayRequestBillEntryCollection entryInfos = info.getEntrys();
		KDTable kdtEntry = editUI.getTableForPrint();
//		KDTable kdtEntry = editUI.getEntryTable();
		// ����û�ɾ�������еķ�¼�����ύʱ����ʾ���ü�¼�Ѳ����ڡ�
		if(info.getId()==null)
		{
			throw new EASBizException(new NumericExceptionSubItem("001","�ü�¼�Ѳ�����"));
		}
		//��ѯԭ��ͬǩ�ʵ���Ϣ
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
		//ԭ��ͬǩ�ʼ����¼
//		ContractManageInfo cmInfo=ContractManageFactory.getRemoteInstance().getContractManageInfo(new ObjectUuidPK(entryInfosCMID));
//		ContractManagePaymentCollection entryInfosCM=cmInfo.getPayment();
		
		
		
		/**
		 * ע�����ݣ��������뵥�ύʱ���ۼƸ���������� ��ͬǩ���Ľ��
		 * 2015-11-14
		 */
//		BigDecimal AmtC=BigDecimal.ZERO;
//		//��� ��ͬǩ�ʵ��Ѹ�����֮��
//		for(int i=0;i<entryInfosCM.size();i++)
//			AmtC = AmtC.add(entryInfosCM.get(i).getPayAmount());
//		//��ø������뵥�ύʱ���ۼ��ύ����Amtc���
//		for(int i=0;i<kdtEntry.getRowCount();i++)
//			AmtC=AmtC.add((BigDecimal) kdtEntry.getRow(i).getCell("auditAmount").getValue());
//		if(AmtC.compareTo(cmInfo.getAmountOriCurrency())!=-1)
//			throw new EASBizException(new NumericExceptionSubItem("001","�ۼ����븶�������ͬ�ܽ�����ʧ��"));
		
		
//		//�������
//		BigDecimal overflow=BigDecimal.ZERO;
//		for(int i=0;i<kdtEntry.getRowCount();i++)
//		{
//			for(int j=0;j<entryInfosCM.size();j++)
//			{
//				//���������������A�Ľ׶α���ͺ�ͬ��¼B������ͬ����A��B���ɣ�
//				if(Integer.valueOf(String.valueOf(kdtEntry.getRow(i).getCell(0).getValue()))==entryInfosCM.get(j).getPhaseCoding())
//				{
//					//��ȡ�������뵥�ϵ��������
//					overflow=(BigDecimal) kdtEntry.getRow(i).getCell("auditAmount").getValue();
//					if(entryInfosCM.get(j).getRequiredPayAmount()==null)
//					{
//						entryInfosCM.get(j).setRequiredPayAmount(new BigDecimal("0"));
//						entryInfosCM.get(j).setReqPayAmountLocalCurrency(BigDecimal.ZERO);
//					}
//					//����������ԭ����Ӧ�׶ε������븶����֮��
//					BigDecimal totalAmount=entryInfosCM.get(j).getRequiredPayAmount().add(overflow);
//					//�����ͬ�׶ο����������������ı��ʲ�Ϊ��
//					if(cmInfo.getBoolean("overFlow")&&entryInfosCM.get(j).getOverRate()!=null)
//					{
//						//������������
//						BigDecimal overAmt = entryInfosCM.get(j).getPayAmount().multiply(entryInfosCM.get(j).getOverRate()).divide(new BigDecimal("100"),6,BigDecimal.ROUND_HALF_EVEN);
//						BigDecimal sumAmt = entryInfosCM.get(j).getPayAmount().add(overAmt);
//						//�Ƚϣ����������ʳ����׳��쳣
//						int compare=totalAmount.compareTo(sumAmt);
//						if(compare==1)						
//							throw new EASBizException(new NumericExceptionSubItem("001","����������ĳ�����������븶��ʧ��"));
//					}
//					else
//					{
//						int compare=totalAmount.compareTo(entryInfosCM.get(j).getPayAmount());
//						if(compare==1)
//							throw new EASBizException(new NumericExceptionSubItem("001","������������븶��ʧ��"));
//					}
//					break;
//				}
//			}
//		}
	}
}
