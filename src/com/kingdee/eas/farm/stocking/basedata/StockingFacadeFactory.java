package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingFacadeFactory
{
    private StockingFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("14FA3E57") ,com.kingdee.eas.farm.stocking.basedata.IStockingFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("14FA3E57") ,com.kingdee.eas.farm.stocking.basedata.IStockingFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("14FA3E57"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("14FA3E57"));
    }
}