package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenRecBillEntryFactory
{
    private ChickenRecBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("922FAC93") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("922FAC93") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("922FAC93"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("922FAC93"));
    }
}