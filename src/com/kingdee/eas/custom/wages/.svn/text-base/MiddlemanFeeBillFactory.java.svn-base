package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MiddlemanFeeBillFactory
{
    private MiddlemanFeeBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("56FDF950") ,com.kingdee.eas.custom.wages.IMiddlemanFeeBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("56FDF950") ,com.kingdee.eas.custom.wages.IMiddlemanFeeBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("56FDF950"));
    }
    public static com.kingdee.eas.custom.wages.IMiddlemanFeeBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMiddlemanFeeBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("56FDF950"));
    }
}