package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ByThePieceBillFactory
{
    private ByThePieceBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IByThePieceBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9D9C8EA3") ,com.kingdee.eas.custom.wages.IByThePieceBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IByThePieceBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9D9C8EA3") ,com.kingdee.eas.custom.wages.IByThePieceBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IByThePieceBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9D9C8EA3"));
    }
    public static com.kingdee.eas.custom.wages.IByThePieceBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IByThePieceBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9D9C8EA3"));
    }
}