package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKCostCalFacadeFactory
{
    private CKCostCalFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("65460B16") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("65460B16") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("65460B16"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCostCalFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("65460B16"));
    }
}