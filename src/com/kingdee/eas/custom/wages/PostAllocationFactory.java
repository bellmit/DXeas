package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PostAllocationFactory
{
    private PostAllocationFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IPostAllocation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B5832BA8") ,com.kingdee.eas.custom.wages.IPostAllocation.class);
    }
    
    public static com.kingdee.eas.custom.wages.IPostAllocation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B5832BA8") ,com.kingdee.eas.custom.wages.IPostAllocation.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IPostAllocation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B5832BA8"));
    }
    public static com.kingdee.eas.custom.wages.IPostAllocation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPostAllocation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B5832BA8"));
    }
}