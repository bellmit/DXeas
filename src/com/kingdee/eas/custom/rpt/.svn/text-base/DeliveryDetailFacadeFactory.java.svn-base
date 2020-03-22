package com.kingdee.eas.custom.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryDetailFacadeFactory
{
    private DeliveryDetailFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.rpt.IDeliveryDetailFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryDetailFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D20BBD1C") ,com.kingdee.eas.custom.rpt.IDeliveryDetailFacade.class);
    }
    
    public static com.kingdee.eas.custom.rpt.IDeliveryDetailFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryDetailFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D20BBD1C") ,com.kingdee.eas.custom.rpt.IDeliveryDetailFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rpt.IDeliveryDetailFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryDetailFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D20BBD1C"));
    }
    public static com.kingdee.eas.custom.rpt.IDeliveryDetailFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rpt.IDeliveryDetailFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D20BBD1C"));
    }
}