package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustmoneyEntryFactory
{
    private AdjustmoneyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAdjustmoneyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoneyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B8180C69") ,com.kingdee.eas.custom.wages.IAdjustmoneyEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAdjustmoneyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoneyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B8180C69") ,com.kingdee.eas.custom.wages.IAdjustmoneyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAdjustmoneyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoneyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B8180C69"));
    }
    public static com.kingdee.eas.custom.wages.IAdjustmoneyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoneyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B8180C69"));
    }
}