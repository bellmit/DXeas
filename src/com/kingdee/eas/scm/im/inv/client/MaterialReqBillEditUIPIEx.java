package com.kingdee.eas.scm.im.inv.client;

import java.awt.event.ActionEvent;

import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;


public class MaterialReqBillEditUIPIEx extends MaterialReqBillEditUI {

	public MaterialReqBillEditUIPIEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		if(editData.getId()==null){
			return;
		}

		String drugBillid = null;
		if(1 == 1){
			String s1 = "/*dialect*/ select t3.fid breedBillid from T_IM_MaterialReqBill t1" +
			" inner join T_BOT_Relation t2 on t2.FDestObjectID = t1.fid" +
			" inner join T_FM_DrugReceiveBill t3 on t2.FSrcObjectID = t3.fid" +
			" where t1.fid = '"+editData.getId()+"'";
			IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
			if(r1.next()){
				drugBillid = r1.getString("breedBillid");
			}
		}
		super.actionRemove_actionPerformed(e);
		//执行删除功能之后
		if(drugBillid != null){
			String s2 = "update T_FM_DrugReceiveBill set FIsHasMaterial = 0 where fid = '"+drugBillid+"'";
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s2);
		}

	}

}
