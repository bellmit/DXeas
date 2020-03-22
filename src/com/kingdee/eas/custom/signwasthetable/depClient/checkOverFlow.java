package com.kingdee.eas.custom.signwasthetable.depClient;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentFactory;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo;
import com.kingdee.eas.fi.ap.PayRequestBillEntryCollection;
import com.kingdee.eas.fi.ap.PayRequestBillEntryInfo;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.ap.client.PayRequestBillEditUI;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class checkOverFlow {
	/*
	 * 该校验作用于  提交和保存
	 * 付款申请单付款金额合法性校验
	 * 允许超额付款情况下 1.如果该阶段的累计申请付款金额超过范围，提示：超出超额比例，申请付款失败
	 * 不循序超额付款情况下：2.如果该阶段的累计申请付款金额超过范围，提示：超过付款金额，申请失败
	 */
	public Boolean beforeSaveRewrite(Object ui) throws EASBizException, BOSException
	{
		//传入的是界面参数，获取付款申请的info和info的分录
		PayRequestBillEditUI editUI = (PayRequestBillEditUI)ui;
		PayRequestBillInfo info = (PayRequestBillInfo) editUI.getEditData();

		KDTable kdtEntry = editUI.getEntryTable();
		if(info.getId()==null)
			return false;

		String contractID = getSrcBillIDByPayReqBill(null,info.getId().toString(),"8C0AA21C");
		if(contractID==null)
			return false;

		PayRequestBillEntryInfo reqEntryInfo=null;
		String srcEntryID;
		BigDecimal auditAmt=BigDecimal.ZERO;
		for(int i=0;i<kdtEntry.getRowCount();i++){
			reqEntryInfo = (PayRequestBillEntryInfo)kdtEntry.getRow(i).getUserObject();
			auditAmt = (BigDecimal) kdtEntry.getCell(i,"auditAmount").getValue();
			srcEntryID = getSrcEntryIDByPayReqBillEntryID(null,reqEntryInfo.getId().toString());
			ContractPaymentInfo cpInfo=ContractPaymentFactory.getRemoteInstance().getContractPaymentInfo(new ObjectUuidPK(srcEntryID));
			if(auditAmt.compareTo(cpInfo.getUnRequiredAmt())>0){
				throw new EASBizException(new NumericExceptionSubItem("001","第"+i+"阶段的金额超出原合同在该阶段的未申请付款金额"));
			}
			if(kdtEntry.getCell(i, "totalPayAmt").getValue()==null)
				kdtEntry.getCell(i, "totalPayAmt").setValue(BigDecimal.ZERO);
		}
		return true;
	}



	public static String getSrcEntryIDByPayReqBillEntryID(Context ctx,String entryID) {
		// TODO Auto-generated method stub
		String str="select FSrcEntryID from T_BOT_RelationEntry where FDestEntryID='"+entryID+"'";
		try {
			IRowSet rs;
			if(ctx==null)
				rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			else
				rs = SQLExecutorFactory.getLocalInstance(ctx, str).executeSQL();
			if(rs.next()){
				return rs.getString("FSrcEntryID");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public static String getSrcBillIDByPayReqBill(Context ctx,String id,String billType){
		if(billType==null)
			return null;
		String sql ="select FSrcObjectID from T_BOT_Relation where FDestObjectID='"+id+"' and FSrcEntityID='"+billType+"'";
		IRowSet rs;
		try {
			if(ctx==null)
				rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			else
				rs = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
			if(rs.size()==0){
				System.out.println("未找到原始单据");
				return null;
			}else
				if(rs.next())
					return rs.getString("FSrcObjectID");
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
