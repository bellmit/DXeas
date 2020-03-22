package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingHatchFacadeFactory
{
    private StockingHatchFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E6C2824") ,com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E6C2824") ,com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E6C2824"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IStockingHatchFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E6C2824"));
    }
}