package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LeavecheckEntryFactory
{
    private LeavecheckEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5E42BADC") ,com.kingdee.eas.custom.foodtrac.ILeavecheckEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5E42BADC") ,com.kingdee.eas.custom.foodtrac.ILeavecheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5E42BADC"));
    }
    public static com.kingdee.eas.custom.foodtrac.ILeavecheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ILeavecheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5E42BADC"));
    }
}