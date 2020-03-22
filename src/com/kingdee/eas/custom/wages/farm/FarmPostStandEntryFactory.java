package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmPostStandEntryFactory
{
    private FarmPostStandEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("86673E7C") ,com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("86673E7C") ,com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("86673E7C"));
    }
    public static com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IFarmPostStandEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("86673E7C"));
    }
}