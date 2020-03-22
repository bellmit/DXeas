package com.kingdee.eas.farm.stocking.assistfunction.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;

public class SettleBillPrintCountControllerBean extends AbstractSettleBillPrintCountControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.assistfunction.app.SettleBillPrintCountControllerBean");

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		DbUtil.execute(ctx, "update T_FM_SettleBillPrintCount set FIsCancel=1 where fid='"+pk.toString()+"'");
	}
    
}