package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustFarmmoneyEntryFactory
{
    private AdjustFarmmoneyEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9D6410E1") ,com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9D6410E1") ,com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9D6410E1"));
    }
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoneyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9D6410E1"));
    }
}