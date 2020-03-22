package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HRwagesFactory
{
    private HRwagesFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IHRwages getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwages)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C9BB9499") ,com.kingdee.eas.custom.wages.IHRwages.class);
    }
    
    public static com.kingdee.eas.custom.wages.IHRwages getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwages)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C9BB9499") ,com.kingdee.eas.custom.wages.IHRwages.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IHRwages getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwages)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C9BB9499"));
    }
    public static com.kingdee.eas.custom.wages.IHRwages getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHRwages)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C9BB9499"));
    }
}