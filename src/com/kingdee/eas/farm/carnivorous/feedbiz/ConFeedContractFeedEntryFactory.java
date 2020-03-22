package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConFeedContractFeedEntryFactory
{
    private ConFeedContractFeedEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("675E0486") ,com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("675E0486") ,com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("675E0486"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractFeedEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("675E0486"));
    }
}