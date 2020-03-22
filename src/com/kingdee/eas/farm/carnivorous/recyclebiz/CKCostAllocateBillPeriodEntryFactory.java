package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKCostAllocateBillPeriodEntryFactory
{
    private CKCostAllocateBillPeriodEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("77C6D43B") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("77C6D43B") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("77C6D43B"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBillPeriodEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("77C6D43B"));
    }
}