package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggPriceDataPriceEntryFactory
{
    private EggPriceDataPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DDE23DE8") ,com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DDE23DE8") ,com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DDE23DE8"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DDE23DE8"));
    }
}