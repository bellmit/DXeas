package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettleBillEntryPriceEntryFactory
{
    private EggSettleBillEntryPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("027A6CCE") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("027A6CCE") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("027A6CCE"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillEntryPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("027A6CCE"));
    }
}