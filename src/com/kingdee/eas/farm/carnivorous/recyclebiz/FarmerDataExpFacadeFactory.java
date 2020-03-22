package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerDataExpFacadeFactory
{
    private FarmerDataExpFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("27FE0E2D") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("27FE0E2D") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("27FE0E2D"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IFarmerDataExpFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("27FE0E2D"));
    }
}