package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKCostAllocateBillFactory
{
    private CKCostAllocateBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EDCBFD16") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EDCBFD16") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EDCBFD16"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostAllocateBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EDCBFD16"));
    }
}