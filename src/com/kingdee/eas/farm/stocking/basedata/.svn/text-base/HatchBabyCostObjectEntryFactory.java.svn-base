package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBabyCostObjectEntryFactory
{
    private HatchBabyCostObjectEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E8732AA1") ,com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E8732AA1") ,com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E8732AA1"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IHatchBabyCostObjectEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E8732AA1"));
    }
}