package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettleBillCompanyEntryPriceEntryFactory
{
    private EggSettleBillCompanyEntryPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0ECD8F0B") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0ECD8F0B") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0ECD8F0B"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntryPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0ECD8F0B"));
    }
}