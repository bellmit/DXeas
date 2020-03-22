package com.kingdee.eas.custom.echickeninterface;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class echickeninterfaceFacadeFactory
{
    private echickeninterfaceFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A232ED9") ,com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade.class);
    }
    
    public static com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A232ED9") ,com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A232ED9"));
    }
    public static com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A232ED9"));
    }
}