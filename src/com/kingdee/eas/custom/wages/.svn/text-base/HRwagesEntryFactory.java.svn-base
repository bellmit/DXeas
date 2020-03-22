package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HRwagesEntryFactory
{
    private HRwagesEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IHRwagesEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwagesEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A9767B59") ,com.kingdee.eas.custom.wages.IHRwagesEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IHRwagesEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwagesEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A9767B59") ,com.kingdee.eas.custom.wages.IHRwagesEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IHRwagesEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwagesEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A9767B59"));
    }
    public static com.kingdee.eas.custom.wages.IHRwagesEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwagesEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A9767B59"));
    }
}