package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmPollingBillInventoryEntryFactory
{
    private FarmPollingBillInventoryEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("583A8606") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("583A8606") ,com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("583A8606"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IFarmPollingBillInventoryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("583A8606"));
    }
}