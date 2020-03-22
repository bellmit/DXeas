package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PostAllocationEntryFactory
{
    private PostAllocationEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IPostAllocationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C76DF5AA") ,com.kingdee.eas.custom.wages.IPostAllocationEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IPostAllocationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C76DF5AA") ,com.kingdee.eas.custom.wages.IPostAllocationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IPostAllocationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C76DF5AA"));
    }
    public static com.kingdee.eas.custom.wages.IPostAllocationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C76DF5AA"));
    }
}