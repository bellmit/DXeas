package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConFeedContractFactory
{
    private ConFeedContractFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9181E08E") ,com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9181E08E") ,com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9181E08E"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9181E08E"));
    }
}