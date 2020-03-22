package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSStockingBreedDailyFacadeFactory
{
    private WSStockingBreedDailyFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2FC9E545") ,com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2FC9E545") ,com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2FC9E545"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingBreedDailyFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2FC9E545"));
    }
}