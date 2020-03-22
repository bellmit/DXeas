package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProcesstechEntryFactory
{
    private ProcesstechEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstechEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("066338B2") ,com.kingdee.eas.custom.foodtrac.IProcesstechEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IProcesstechEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("066338B2") ,com.kingdee.eas.custom.foodtrac.IProcesstechEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstechEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("066338B2"));
    }
    public static com.kingdee.eas.custom.foodtrac.IProcesstechEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProcesstechEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("066338B2"));
    }
}