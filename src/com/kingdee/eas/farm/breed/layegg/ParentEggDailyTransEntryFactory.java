package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ParentEggDailyTransEntryFactory
{
    private ParentEggDailyTransEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("11270EB5") ,com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("11270EB5") ,com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("11270EB5"));
    }
    public static com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.IParentEggDailyTransEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("11270EB5"));
    }
}