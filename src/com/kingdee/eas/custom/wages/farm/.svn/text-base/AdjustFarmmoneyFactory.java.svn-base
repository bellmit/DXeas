package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustFarmmoneyFactory
{
    private AdjustFarmmoneyFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E678AA11") ,com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E678AA11") ,com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E678AA11"));
    }
    public static com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IAdjustFarmmoney)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E678AA11"));
    }
}