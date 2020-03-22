package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeedCostPriceFactory
{
    private FeedCostPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D1CABB1C") ,com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D1CABB1C") ,com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D1CABB1C"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFeedCostPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D1CABB1C"));
    }
}