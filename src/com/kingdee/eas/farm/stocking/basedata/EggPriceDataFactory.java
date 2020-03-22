package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggPriceDataFactory
{
    private EggPriceDataFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B1FA9FDF") ,com.kingdee.eas.farm.stocking.basedata.IEggPriceData.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B1FA9FDF") ,com.kingdee.eas.farm.stocking.basedata.IEggPriceData.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B1FA9FDF"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B1FA9FDF"));
    }
}