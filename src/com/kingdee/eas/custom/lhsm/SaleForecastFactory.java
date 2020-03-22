package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleForecastFactory
{
    private SaleForecastFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ISaleForecast getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecast)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FFAFDB4F") ,com.kingdee.eas.custom.lhsm.ISaleForecast.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ISaleForecast getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecast)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FFAFDB4F") ,com.kingdee.eas.custom.lhsm.ISaleForecast.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ISaleForecast getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecast)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FFAFDB4F"));
    }
    public static com.kingdee.eas.custom.lhsm.ISaleForecast getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleForecast)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FFAFDB4F"));
    }
}