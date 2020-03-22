package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarSendBillFactory
{
    private CarSendBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarSendBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1068EFAD") ,com.kingdee.eas.custom.taihe.weight.ICarSendBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarSendBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1068EFAD") ,com.kingdee.eas.custom.taihe.weight.ICarSendBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarSendBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1068EFAD"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarSendBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarSendBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1068EFAD"));
    }
}