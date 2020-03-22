package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmFactory
{
    private FarmFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD78C307") ,com.kingdee.eas.farm.stocking.basedata.IFarm.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD78C307") ,com.kingdee.eas.farm.stocking.basedata.IFarm.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD78C307"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD78C307"));
    }
}