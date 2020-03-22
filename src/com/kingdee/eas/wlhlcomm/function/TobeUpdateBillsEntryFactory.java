package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TobeUpdateBillsEntryFactory
{
    private TobeUpdateBillsEntryFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("11F369EC") ,com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("11F369EC") ,com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("11F369EC"));
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("11F369EC"));
    }
}