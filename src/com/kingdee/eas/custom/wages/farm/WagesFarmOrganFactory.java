package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WagesFarmOrganFactory
{
    private WagesFarmOrganFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4B36CA1A") ,com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4B36CA1A") ,com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4B36CA1A"));
    }
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrgan)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4B36CA1A"));
    }
}