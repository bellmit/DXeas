package com.kingdee.eas.custom.signwasthetable.depClient;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.*;
import com.kingdee.eas.fi.ap.PayRequestBillEntryCollection;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.ap.client.PayRequestBillEditUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class payReqOnLoad {
	protected PayRequestBillInfo editData;
	public Boolean  createTraceBill(PayRequestBillEditUI ui) throws EASBizException, BOSException
	{	
		editData = (PayRequestBillInfo) ui.getEditData();
		if(editData.getId()==null)
			SysUtil.abort();
		String id = editData.getEntrys().get(0).getId().toString();
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t3.fparentid from T_SIG_ContractPayment t3 ");
		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
		buffer.append(" where t1.fid='").append(id).append("'");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		try {
			if(rs.next())				
			{
				String cmId=rs.getString("fparentid");
				ContractInfo cmInfo = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(cmId));
				ContractPaymentCollection cmEntry = cmInfo.getPayment();


				KDTable kdtEntry = ui.getEntryTable();
//				KDTable kdtEntry = ui.getEntryTable();


				PayRequestBillEntryCollection prEntry = editData.getEntrys();
				for(int i=0;i<prEntry.size();i++)
				{
					for(int j=0;j<cmEntry.size();j++)
					{
						String fid = prEntry.get(i).getId().toString();//付款申请阶段的id
						String ffid=search(fid);//付款申请阶段的对应的付款阶段的id
						if(ffid.equals(cmEntry.get(j).getId().toString()))
						{					
							int row = prEntry.get(i).getSeq()-1;
							kdtEntry.getRow(row).getCell(0).setValue(cmEntry.get(j).getPhaseCoding());
							if(searchAdminOrg(cmEntry.get(j).getId().toString())!=null)
								kdtEntry.getRow(row).getCell(1).setValue(searchAdminOrg(cmEntry.get(j).getId().toString()));
							break;
						}
					}
				}
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	/*
	 * 为生成的付款申请单添加两个字段：付款阶段，行政组织（均取值于合同签呈分录）
	 */
	public Boolean  createTraceBillloadfields(PayRequestBillEditUI ui) throws EASBizException, BOSException
	{				
		//界面传过来的是EditUI
		editData = (PayRequestBillInfo) ui.getEditData();
		//用户删除当前的分款申请单再次操作时为避免报错（异常），提前退出
		if(editData.getId()==null)
			return false;
		//获取原合同签呈id
		String id = editData.getEntrys().get(0).getId().toString();
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t3.fparentid from T_SIG_ContractPayment t3 ");
		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
		buffer.append(" where t1.fid='").append(id).append("'");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		try {
			if(rs.next())				
			{
				String cmId=rs.getString("fparentid");
				//根据id获取原合同签呈的info以及分录
				ContractInfo cmInfo = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(cmId));
				ContractPaymentCollection cmEntry = cmInfo.getPayment();

				KDTable kdtEntry = ui.getEntryTable();
//				KDTable kdtEntry = ui.getEntryTable();

				PayRequestBillEntryCollection prEntry = editData.getEntrys();
				//付款申请单的第一个分录字段若不是“付款阶段”，则认定为界面加载，添加两个字段，否则直接赋值即可
				if(kdtEntry.getHeadRow(0).getCell(0).getValue()!="付款阶段")
				{
					kdtEntry.addColumn(0);
					kdtEntry.addColumn(1);
					kdtEntry.getHeadRow(0).getCell(0).setValue("付款阶段");
					kdtEntry.getHeadRow(0).getCell(1).setValue("行政组织");
					kdtEntry.getColumn(0).getStyleAttributes().setLocked(true);
					kdtEntry.getColumn(1).getStyleAttributes().setLocked(true);
				}
				//新添加的两个字段进行赋值
				for(int i=0;i<prEntry.size();i++)
				{
					for(int j=0;j<cmEntry.size();j++)
					{
						String fid = prEntry.get(i).getId().toString();//付款申请阶段的id
						String ffid=search(fid);//付款申请阶段的对应的付款阶段的id
						if(ffid.equals(cmEntry.get(j).getId().toString()))
						{					
							int row = prEntry.get(i).getSeq()-1;
							kdtEntry.getRow(row).getCell(0).setValue(cmEntry.get(j).getPhaseCoding());
							//由于cmEntry.get(j).getAdminOrg()取不到值，所以用sql查询，searchAdminOrg（）为新定义的查询方法
							if(searchAdminOrg(cmEntry.get(j).getId().toString())!=null)
								kdtEntry.getRow(row).getCell(1).setValue(searchAdminOrg(cmEntry.get(j).getId().toString()));
							break;
						}
					}
				}
				return true;
			}
			else 
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public AdminOrgUnitInfo searchAdminOrg(String admin)
	{
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t2.fid from T_SIG_ContractPayment t1 ");
		buffer.append("inner join T_ORG_Admin t2 ");
		buffer.append("on t2.fid=t1.fadminorgid");
		buffer.append(" where t1.fid='").append(admin).append("'");
		try {
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
			if(rs.next())
			{
				return AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public String search(String idString)
	{
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t3.fid from T_SIG_ContractPayment t3 ");
		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
		buffer.append(" where t1.fid='").append(idString).append("'");
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
			if(rs.next())
				return rs.getString("fid");
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


	}
}
