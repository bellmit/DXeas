package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerSprayInvEntryFactory
{
    private CustomerSprayInvEntryFactory()
    {
    }
    public static com.kingdee.eas.spray.ICustomerSprayInvEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87D2997D") ,com.kingdee.eas.spray.ICustomerSprayInvEntry.class);
    }
    
    public static com.kingdee.eas.spray.ICustomerSprayInvEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87D2997D") ,com.kingdee.eas.spray.ICustomerSprayInvEntry.class, objectCtx);
    }
    public static com.kingdee.eas.spray.ICustomerSprayInvEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87D2997D"));
    }
    public static com.kingdee.eas.spray.ICustomerSprayInvEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87D2997D"));
    }
}