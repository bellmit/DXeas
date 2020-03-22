package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenRecBillButcherEntryFactory
{
    private ChickenRecBillButcherEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("65F6FF1E") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("65F6FF1E") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("65F6FF1E"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBillButcherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("65F6FF1E"));
    }
}