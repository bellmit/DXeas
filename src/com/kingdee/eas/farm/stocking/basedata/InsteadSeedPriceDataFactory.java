package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsteadSeedPriceDataFactory
{
    private InsteadSeedPriceDataFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E8049D1") ,com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E8049D1") ,com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E8049D1"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E8049D1"));
    }
}