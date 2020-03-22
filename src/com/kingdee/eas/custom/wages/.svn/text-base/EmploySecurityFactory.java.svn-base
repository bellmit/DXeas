package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmploySecurityFactory
{
    private EmploySecurityFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IEmploySecurity getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurity)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9D8420F6") ,com.kingdee.eas.custom.wages.IEmploySecurity.class);
    }
    
    public static com.kingdee.eas.custom.wages.IEmploySecurity getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurity)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9D8420F6") ,com.kingdee.eas.custom.wages.IEmploySecurity.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IEmploySecurity getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurity)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9D8420F6"));
    }
    public static com.kingdee.eas.custom.wages.IEmploySecurity getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurity)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9D8420F6"));
    }
}