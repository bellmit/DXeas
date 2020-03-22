package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TobeUpdateBillsFactory
{
    private TobeUpdateBillsFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("85129626") ,com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("85129626") ,com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("85129626"));
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBills)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("85129626"));
    }
}