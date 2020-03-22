package com.kingdee.eas.farm.carnivorous.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSStockingDailyFacadeFactory
{
    private WSStockingDailyFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49C7CB1C") ,com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49C7CB1C") ,com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49C7CB1C"));
    }
    public static com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49C7CB1C"));
    }
}