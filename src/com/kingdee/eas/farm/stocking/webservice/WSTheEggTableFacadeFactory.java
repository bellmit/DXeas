package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSTheEggTableFacadeFactory
{
    private WSTheEggTableFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CA18C6BA") ,com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CA18C6BA") ,com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CA18C6BA"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSTheEggTableFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CA18C6BA"));
    }
}