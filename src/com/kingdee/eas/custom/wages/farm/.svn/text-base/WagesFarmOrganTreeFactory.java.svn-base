package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WagesFarmOrganTreeFactory
{
    private WagesFarmOrganTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E05814D8") ,com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E05814D8") ,com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E05814D8"));
    }
    public static com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IWagesFarmOrganTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E05814D8"));
    }
}