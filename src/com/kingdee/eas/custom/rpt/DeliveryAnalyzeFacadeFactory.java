package com.kingdee.eas.custom.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryAnalyzeFacadeFactory
{
    private DeliveryAnalyzeFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("879AA255") ,com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade.class);
    }
    
    public static com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("879AA255") ,com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("879AA255"));
    }
    public static com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryAnalyzeFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("879AA255"));
    }
}