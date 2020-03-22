package com.kingdee.eas.dep.client;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.szcount.SzSemiProductFactory;
import com.kingdee.eas.custom.szcount.SzSemiProductInfo;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillInfo;
import com.kingdee.eas.scm.im.inv.client.ManufactureRecBillEditUI;
import com.kingdee.jdbc.rowset.IRowSet;

public class ManufactureRecBill {
	public static void afterDeleteChange(Context ctx,final Object param){
		/*ManufactureRecBillEditUI ManufactureRecBillEditUI = (ManufactureRecBillEditUI)param.getUI();
		ManufactureRecBillEditUI ui = ManufactureRecBillEditUI;
		ManufactureRecBillInfo editData = (ManufactureRecBillInfo) ui.getEditData();
		editData.getId();*/
		StringBuffer sb = new StringBuffer();
		String sp = "\n";
		sb.append("select t1.FID FID from ").append(sp);
		sb.append("CT_SZC_SzSemiProduct		t1").append(sp);
		sb.append("inner join T_BOT_Relation		t2	on t2.FSrcObjectID = t1.FID").append(sp);
		sb.append("inner join T_IM_ManufactureRecBill	t3	on t3.FID = t2.FDestObjectID").append(sp);
		sb.append("where t3.FID = '").append(param).append("'").append(sp);
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				String id = rs.getString("FID");
				SzSemiProductInfo info = SzSemiProductFactory.getRemoteInstance().getSzSemiProductInfo(new ObjectUuidPK(id));
				info.setWhetherProduction(false);
				SzSemiProductFactory.getRemoteInstance().save(info);
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
		
		
	}

}
