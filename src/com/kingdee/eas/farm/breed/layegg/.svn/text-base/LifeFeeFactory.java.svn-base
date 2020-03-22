package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LifeFeeFactory
{
    private LifeFeeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILifeFee getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFee)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F41635BD") ,com.kingdee.eas.farm.breed.layegg.ILifeFee.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILifeFee getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFee)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F41635BD") ,com.kingdee.eas.farm.breed.layegg.ILifeFee.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILifeFee getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFee)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F41635BD"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILifeFee getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILifeFee)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F41635BD"));
    }
}