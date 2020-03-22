package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EarlyEggStockEntryFactory
{
    private EarlyEggStockEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEarlyEggStockEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStockEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF7118CC") ,com.kingdee.eas.farm.hatch.IEarlyEggStockEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEarlyEggStockEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStockEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF7118CC") ,com.kingdee.eas.farm.hatch.IEarlyEggStockEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEarlyEggStockEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStockEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF7118CC"));
    }
    public static com.kingdee.eas.farm.hatch.IEarlyEggStockEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEarlyEggStockEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF7118CC"));
    }
}