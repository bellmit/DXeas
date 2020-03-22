package com.kingdee.eas.delivery.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DeliveryLineEntryFactory
{
    private DeliveryLineEntryFactory()
    {
    }
    public static com.kingdee.eas.delivery.basedata.IDeliveryLineEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLineEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F9A3773F") ,com.kingdee.eas.delivery.basedata.IDeliveryLineEntry.class);
    }
    
    public static com.kingdee.eas.delivery.basedata.IDeliveryLineEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLineEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F9A3773F") ,com.kingdee.eas.delivery.basedata.IDeliveryLineEntry.class, objectCtx);
    }
    public static com.kingdee.eas.delivery.basedata.IDeliveryLineEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLineEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F9A3773F"));
    }
    public static com.kingdee.eas.delivery.basedata.IDeliveryLineEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.delivery.basedata.IDeliveryLineEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F9A3773F"));
    }
}