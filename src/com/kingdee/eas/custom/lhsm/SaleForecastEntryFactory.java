package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleForecastEntryFactory
{
    private SaleForecastEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ISaleForecastEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecastEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B5CFF663") ,com.kingdee.eas.custom.lhsm.ISaleForecastEntry.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ISaleForecastEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecastEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B5CFF663") ,com.kingdee.eas.custom.lhsm.ISaleForecastEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ISaleForecastEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecastEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B5CFF663"));
    }
    public static com.kingdee.eas.custom.lhsm.ISaleForecastEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecastEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B5CFF663"));
    }
}