package com.kingdee.eas.custom.signwasthetable.depPlugin;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.ap.client.PayRequestBillEditUI;
import com.kingdee.jdbc.rowset.IRowSet;
/*
 * 合同签呈付款单的分录不允许增加和插入操作（步骤二）
 * 
 * 付款申请单界面打开时加载方法，传过来EditUI界面参数(步骤一)
 * 通过参数获得editData，editData的id查询是否上游单据是合同签呈（若是，则返回true，否则返回false）（步骤二）
 * 根据返回值修改界面的分录增加和删除的按钮
 */
public class createPayBillEditUI {
	protected PayRequestBillInfo editData;
	public Boolean  createTraceBill(PayRequestBillEditUI ui) throws EASBizException, BOSException
	{
		editData = (PayRequestBillInfo) ui.getEditData();
		String id = editData.getEntrys().get(0).getId().toString();
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t3.fparentid from T_SIG_ContractManagePayment t3 ");
		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
		buffer.append(" where t1.fid='").append(id).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		try {
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
