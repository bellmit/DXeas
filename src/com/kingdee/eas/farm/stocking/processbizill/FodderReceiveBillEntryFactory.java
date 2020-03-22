package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderReceiveBillEntryFactory
{
    private FodderReceiveBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D4752043") ,com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D4752043") ,com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D4752043"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D4752043"));
    }
}