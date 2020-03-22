package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchRptFacadeFactory
{
    private HatchRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D5E44E0E") ,com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D5E44E0E") ,com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D5E44E0E"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IHatchRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D5E44E0E"));
    }
}