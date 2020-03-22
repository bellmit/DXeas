package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKCostAllocateBillEntryFactory
{
    private CKCostAllocateBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DCB4D8FC") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DCB4D8FC") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DCB4D8FC"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DCB4D8FC"));
    }
}