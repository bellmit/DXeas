package com.kingdee.eas.farm.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmCodeTreeFactory
{
    private FarmCodeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.foodtrac.IFarmCodeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCodeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6F0B6C8B") ,com.kingdee.eas.farm.foodtrac.IFarmCodeTree.class);
    }
    
    public static com.kingdee.eas.farm.foodtrac.IFarmCodeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCodeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6F0B6C8B") ,com.kingdee.eas.farm.foodtrac.IFarmCodeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.foodtrac.IFarmCodeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCodeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6F0B6C8B"));
    }
    public static com.kingdee.eas.farm.foodtrac.IFarmCodeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.foodtrac.IFarmCodeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6F0B6C8B"));
    }
}