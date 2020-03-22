package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSStockingOfAccountFacadeFactory
{
    private WSStockingOfAccountFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70BCA48A") ,com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70BCA48A") ,com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70BCA48A"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingOfAccountFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70BCA48A"));
    }
}