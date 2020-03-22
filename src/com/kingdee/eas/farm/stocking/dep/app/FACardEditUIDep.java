package com.kingdee.eas.farm.stocking.dep.app;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.fi.fa.manage.FaCurCardInfo;
import com.kingdee.eas.util.app.DbUtil;

public class FACardEditUIDep {

	public static void afterSaveFACard(Context ctx,Object id){
		try {
			FaCurCardInfo info= (FaCurCardInfo) id;
			DbUtil.execute(ctx,"update T_FA_FaCurCard set CFStockingBatchID=CFBreedBatchID where fid='"+info.getString("id")+"'");
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
