package com.kingdee.eas.custom.taihe.settle.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;

public class SettleBillControllerBeanEx extends com.kingdee.eas.custom.taihe.settle.app.SettleBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.settle.app.SettleBillControllerBeanEx");
    protected void _execute(Context ctx, IObjectValue model)throws BOSException
    {
	     super._execute(ctx, model);
    }
}				
