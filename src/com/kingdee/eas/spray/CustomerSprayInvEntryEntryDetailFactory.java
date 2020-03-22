package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerSprayInvEntryEntryDetailFactory
{
    private CustomerSprayInvEntryEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B39D9DA6") ,com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail.class);
    }
    
    public static com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B39D9DA6") ,com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B39D9DA6"));
    }
    public static com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInvEntryEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B39D9DA6"));
    }
}