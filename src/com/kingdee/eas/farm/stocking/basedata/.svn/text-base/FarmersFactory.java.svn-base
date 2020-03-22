package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmersFactory
{
    private FarmersFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmers getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmers)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("183114FF") ,com.kingdee.eas.farm.stocking.basedata.IFarmers.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmers getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmers)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("183114FF") ,com.kingdee.eas.farm.stocking.basedata.IFarmers.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmers getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmers)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("183114FF"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmers getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmers)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("183114FF"));
    }
}