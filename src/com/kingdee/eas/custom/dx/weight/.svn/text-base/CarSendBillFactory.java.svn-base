package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarSendBillFactory
{
    private CarSendBillFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9BC90962") ,com.kingdee.eas.custom.dx.weight.ICarSendBill.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.ICarSendBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9BC90962") ,com.kingdee.eas.custom.dx.weight.ICarSendBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9BC90962"));
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9BC90962"));
    }
}