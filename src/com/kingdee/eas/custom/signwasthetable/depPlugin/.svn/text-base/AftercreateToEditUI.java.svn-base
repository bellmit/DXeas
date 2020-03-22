package com.kingdee.eas.custom.signwasthetable.depPlugin;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.cas.PaymentBillEntryCollection;
import com.kingdee.eas.fi.cas.PaymentBillFactory;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class AftercreateToEditUI {
	public void afterCreateTo(Context ctx,String id) throws EASBizException, BOSException
	{
		PaymentBillInfo info=PaymentBillFactory.getLocalInstance(ctx).getPaymentBillInfo(new ObjectUuidPK(id));
		PaymentBillEntryCollection paymentEntry=info.getEntries();//获取付款单的分录
		for(int i=0;i<paymentEntry.size();i++)
		{
			String payReqEntryID=paymentEntry.get(i).getSourceBillEntryId();
			StringBuffer buffer=new StringBuffer();
			buffer.append("select t3.fparentid,t3.fid from T_SIG_ContractManagePayment t ");
			buffer.append("inner join T_BOT_RelationEntry t2 on t1.fid=t2.FSrcObjectID ");
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			ContractManagePaymentInfo cmpInfo=ContractManagePaymentFactory.getLocalInstance(ctx).getContractManagePaymentInfo(new ObjectUuidPK(cmpid));
//			ContractManageInfo cmInfo=ContractManageFactory.getLocalInstance(ctx).getContractManageInfo(new ObjectUuidPK(cmpEntryID));		

		}
	}
}
