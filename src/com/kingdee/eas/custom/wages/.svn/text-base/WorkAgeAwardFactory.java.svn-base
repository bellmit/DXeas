package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WorkAgeAwardFactory
{
    private WorkAgeAwardFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAward getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAward)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E64BF2D7") ,com.kingdee.eas.custom.wages.IWorkAgeAward.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWorkAgeAward getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAward)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E64BF2D7") ,com.kingdee.eas.custom.wages.IWorkAgeAward.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAward getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAward)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E64BF2D7"));
    }
    public static com.kingdee.eas.custom.wages.IWorkAgeAward getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWorkAgeAward)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E64BF2D7"));
    }
}