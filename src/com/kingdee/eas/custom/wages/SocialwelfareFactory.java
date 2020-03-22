package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SocialwelfareFactory
{
    private SocialwelfareFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.ISocialwelfare getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfare)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0C265977") ,com.kingdee.eas.custom.wages.ISocialwelfare.class);
    }
    
    public static com.kingdee.eas.custom.wages.ISocialwelfare getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfare)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0C265977") ,com.kingdee.eas.custom.wages.ISocialwelfare.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.ISocialwelfare getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfare)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0C265977"));
    }
    public static com.kingdee.eas.custom.wages.ISocialwelfare getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfare)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0C265977"));
    }
}