package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasicPostFarmFactory
{
    private BasicPostFarmFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0781235A") ,com.kingdee.eas.custom.wages.farm.IBasicPostFarm.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0781235A") ,com.kingdee.eas.custom.wages.farm.IBasicPostFarm.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0781235A"));
    }
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0781235A"));
    }
}