package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggRecycleFactory
{
    private EggRecycleFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycle getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycle)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D5DC63F3") ,com.kingdee.eas.farm.stocking.processbizill.IEggRecycle.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycle getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycle)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D5DC63F3") ,com.kingdee.eas.farm.stocking.processbizill.IEggRecycle.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycle getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycle)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D5DC63F3"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IEggRecycle getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IEggRecycle)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D5DC63F3"));
    }
}