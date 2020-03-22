package com.kingdee.eas.weighbridge.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CommSqlFacadeControllerBean extends AbstractCommSqlFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.CommSqlFacadeControllerBean");
    @Override
	protected void _execute(Context ctx, String sqlStr, Object[] params)
			throws BOSException {
		DbUtil.execute(ctx, sqlStr,params);
	}

	@Override
	protected void _execute(Context ctx, String sqlStr) throws BOSException {
		DbUtil.execute(ctx, sqlStr);
	}

	@Override
	protected IRowSet _executeQuery(Context ctx, String sqlStr, Object[] params)
			throws BOSException {
		return DbUtil.executeQuery(ctx, sqlStr, params);
	}

	@Override
	protected IRowSet _executeQuery(Context ctx, String sqlStr)
			throws BOSException {
		return DbUtil.executeQuery(ctx, sqlStr);
	}
}