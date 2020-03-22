package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChickenDailyPriceFactory
{
    private ChickenDailyPriceFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("96BCA162") ,com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("96BCA162") ,com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("96BCA162"));
    }
    public static com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.IChickenDailyPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("96BCA162"));
    }
}