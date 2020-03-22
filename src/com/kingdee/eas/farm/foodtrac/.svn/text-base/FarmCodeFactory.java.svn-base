package com.kingdee.eas.farm.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmCodeFactory
{
    private FarmCodeFactory()
    {
    }
    public static com.kingdee.eas.farm.foodtrac.IFarmCode getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCode)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CDD7F34D") ,com.kingdee.eas.farm.foodtrac.IFarmCode.class);
    }
    
    public static com.kingdee.eas.farm.foodtrac.IFarmCode getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCode)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CDD7F34D") ,com.kingdee.eas.farm.foodtrac.IFarmCode.class, objectCtx);
    }
    public static com.kingdee.eas.farm.foodtrac.IFarmCode getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCode)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CDD7F34D"));
    }
    public static com.kingdee.eas.farm.foodtrac.IFarmCode getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCode)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CDD7F34D"));
    }
}