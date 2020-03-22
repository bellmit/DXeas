package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenRecBillFactory
{
    private ChickenRecBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B283071F") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B283071F") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B283071F"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B283071F"));
    }
}