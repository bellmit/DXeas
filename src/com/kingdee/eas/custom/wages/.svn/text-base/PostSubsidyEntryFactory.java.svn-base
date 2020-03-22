package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PostSubsidyEntryFactory
{
    private PostSubsidyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IPostSubsidyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("02A8784F") ,com.kingdee.eas.custom.wages.IPostSubsidyEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IPostSubsidyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("02A8784F") ,com.kingdee.eas.custom.wages.IPostSubsidyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IPostSubsidyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("02A8784F"));
    }
    public static com.kingdee.eas.custom.wages.IPostSubsidyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostSubsidyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("02A8784F"));
    }
}