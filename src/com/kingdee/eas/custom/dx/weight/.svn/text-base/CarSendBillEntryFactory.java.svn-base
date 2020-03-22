package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarSendBillEntryFactory
{
    private CarSendBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("60AF9C30") ,com.kingdee.eas.custom.dx.weight.ICarSendBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("60AF9C30") ,com.kingdee.eas.custom.dx.weight.ICarSendBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("60AF9C30"));
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("60AF9C30"));
    }
}