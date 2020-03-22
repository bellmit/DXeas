package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmPostStandFactory
{
    private FarmPostStandFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStand getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStand)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("64902796") ,com.kingdee.eas.custom.wages.farm.IFarmPostStand.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStand getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStand)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("64902796") ,com.kingdee.eas.custom.wages.farm.IFarmPostStand.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStand getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStand)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("64902796"));
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStand getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStand)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("64902796"));
    }
}