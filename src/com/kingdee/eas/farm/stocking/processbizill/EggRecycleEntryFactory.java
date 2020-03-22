package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggRecycleEntryFactory
{
    private EggRecycleEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0613343F") ,com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0613343F") ,com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0613343F"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycleEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0613343F"));
    }
}