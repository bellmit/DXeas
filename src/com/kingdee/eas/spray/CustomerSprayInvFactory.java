package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerSprayInvFactory
{
    private CustomerSprayInvFactory()
    {
    }
    public static com.kingdee.eas.spray.ICustomerSprayInv getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInv)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FDC62FF5") ,com.kingdee.eas.spray.ICustomerSprayInv.class);
    }
    
    public static com.kingdee.eas.spray.ICustomerSprayInv getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInv)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FDC62FF5") ,com.kingdee.eas.spray.ICustomerSprayInv.class, objectCtx);
    }
    public static com.kingdee.eas.spray.ICustomerSprayInv getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInv)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FDC62FF5"));
    }
    public static com.kingdee.eas.spray.ICustomerSprayInv getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.spray.ICustomerSprayInv)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FDC62FF5"));
    }
}