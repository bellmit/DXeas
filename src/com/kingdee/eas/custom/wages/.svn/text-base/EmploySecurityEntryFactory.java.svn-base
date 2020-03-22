package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EmploySecurityEntryFactory
{
    private EmploySecurityEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IEmploySecurityEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurityEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("77D8211C") ,com.kingdee.eas.custom.wages.IEmploySecurityEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IEmploySecurityEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurityEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("77D8211C") ,com.kingdee.eas.custom.wages.IEmploySecurityEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IEmploySecurityEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurityEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("77D8211C"));
    }
    public static com.kingdee.eas.custom.wages.IEmploySecurityEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IEmploySecurityEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("77D8211C"));
    }
}