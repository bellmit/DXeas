package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBabyCostObjectFactory
{
    private HatchBabyCostObjectFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3D507851") ,com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3D507851") ,com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3D507851"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObject)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3D507851"));
    }
}