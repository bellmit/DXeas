package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthlysalarybillEntryFactory
{
    private MonthlysalarybillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IMonthlysalarybillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6897D47C") ,com.kingdee.eas.custom.wages.IMonthlysalarybillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IMonthlysalarybillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6897D47C") ,com.kingdee.eas.custom.wages.IMonthlysalarybillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IMonthlysalarybillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6897D47C"));
    }
    public static com.kingdee.eas.custom.wages.IMonthlysalarybillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6897D47C"));
    }
}