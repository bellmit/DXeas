package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenRecBillWeigntEntryFactory
{
    private ChickenRecBillWeigntEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92E24BC1") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92E24BC1") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92E24BC1"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillWeigntEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92E24BC1"));
    }
}