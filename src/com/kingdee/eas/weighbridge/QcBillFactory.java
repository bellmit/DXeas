package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QcBillFactory
{
    private QcBillFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IQcBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AD0E64D4") ,com.kingdee.eas.weighbridge.IQcBill.class);
    }
    
    public static com.kingdee.eas.weighbridge.IQcBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AD0E64D4") ,com.kingdee.eas.weighbridge.IQcBill.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IQcBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AD0E64D4"));
    }
    public static com.kingdee.eas.weighbridge.IQcBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AD0E64D4"));
    }
}