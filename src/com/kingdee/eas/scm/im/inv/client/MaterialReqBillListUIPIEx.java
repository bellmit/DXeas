package com.kingdee.eas.scm.im.inv.client;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.framework.batchaction.BatchActionEnum;
import com.kingdee.eas.framework.batchaction.BatchSelectionEntries;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.StringUtils;


public class MaterialReqBillListUIPIEx extends MaterialReqBillListUI {
	//获得源单据的id
	String breedBillid = null;
	String drugBillid = null;
	public MaterialReqBillListUIPIEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void afterAction(BatchActionEnum arg0, BatchSelectionEntries arg1,
			int arg2) {
		// TODO Auto-generated method stub
		super.afterAction(arg0, arg1, arg2);

		//执行删除功能之后
		if(drugBillid != null){
			String s2 = "update T_FM_DrugReceiveBill set FIsHasMaterial = 0 where fid = '"+drugBillid+"'";
			try {
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s2);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public boolean beforeAction(BatchActionEnum bizAction,
			BatchSelectionEntries selectionEntries, ActionEvent event) {
		// TODO Auto-generated method stub

		if(bizAction.equals(BatchActionEnum.DELETE)){
			String id = this.getSelectedKeyValue();
			if(StringUtils.isEmpty(id)){
				return false;
			}
			String s1 = "/*dialect*/ select t3.fid breedBillid from T_IM_MaterialReqBill t1" +
			" inner join T_BOT_Relation t2 on t2.FDestObjectID = t1.fid" +
			" inner join T_FM_DrugReceiveBill t3 on t2.FSrcObjectID = t3.fid" +
			" where t1.fid = '"+id+"'";
			IRowSet r1;
			try {
				r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
				if(r1.next()){
					drugBillid = r1.getString("breedBillid");
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.beforeAction(bizAction, selectionEntries, event);
	}






}
