package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedCostPriceEntryFactory
{
    private FeedCostPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0A79EEB6") ,com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0A79EEB6") ,com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0A79EEB6"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0A79EEB6"));
    }
}