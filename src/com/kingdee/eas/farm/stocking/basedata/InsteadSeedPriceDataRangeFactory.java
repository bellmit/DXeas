package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsteadSeedPriceDataRangeFactory
{
    private InsteadSeedPriceDataRangeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CC9B79EC") ,com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CC9B79EC") ,com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CC9B79EC"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataRange)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CC9B79EC"));
    }
}