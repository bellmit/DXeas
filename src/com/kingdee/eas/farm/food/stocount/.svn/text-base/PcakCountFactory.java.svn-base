package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PcakCountFactory
{
    private PcakCountFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.IPcakCount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0599DF95") ,com.kingdee.eas.farm.food.stocount.IPcakCount.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.IPcakCount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0599DF95") ,com.kingdee.eas.farm.food.stocount.IPcakCount.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.IPcakCount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0599DF95"));
    }
    public static com.kingdee.eas.farm.food.stocount.IPcakCount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0599DF95"));
    }
}