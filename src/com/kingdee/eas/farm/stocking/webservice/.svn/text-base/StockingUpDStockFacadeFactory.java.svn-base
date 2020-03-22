package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingUpDStockFacadeFactory
{
    private StockingUpDStockFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("09476CF1") ,com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("09476CF1") ,com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("09476CF1"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IStockingUpDStockFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("09476CF1"));
    }
}