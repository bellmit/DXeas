package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LifeFeeEntryFactory
{
    private LifeFeeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E106F0B5") ,com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E106F0B5") ,com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E106F0B5"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFeeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E106F0B5"));
    }
}