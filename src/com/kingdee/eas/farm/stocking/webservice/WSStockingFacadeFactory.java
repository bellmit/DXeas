package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSStockingFacadeFactory
{
    private WSStockingFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("30747360") ,com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("30747360") ,com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("30747360"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("30747360"));
    }
}