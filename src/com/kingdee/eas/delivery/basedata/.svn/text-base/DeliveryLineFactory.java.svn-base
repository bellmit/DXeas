package com.kingdee.eas.delivery.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryLineFactory
{
    private DeliveryLineFactory()
    {
    }
    public static com.kingdee.eas.delivery.basedata.IDeliveryLine getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLine)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23EE40F3") ,com.kingdee.eas.delivery.basedata.IDeliveryLine.class);
    }
    
    public static com.kingdee.eas.delivery.basedata.IDeliveryLine getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLine)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23EE40F3") ,com.kingdee.eas.delivery.basedata.IDeliveryLine.class, objectCtx);
    }
    public static com.kingdee.eas.delivery.basedata.IDeliveryLine getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLine)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23EE40F3"));
    }
    public static com.kingdee.eas.delivery.basedata.IDeliveryLine getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLine)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23EE40F3"));
    }
}