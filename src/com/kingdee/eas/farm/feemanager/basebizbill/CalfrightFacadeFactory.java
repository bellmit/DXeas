package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CalfrightFacadeFactory
{
    private CalfrightFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("809AAF18") ,com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("809AAF18") ,com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("809AAF18"));
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("809AAF18"));
    }
}