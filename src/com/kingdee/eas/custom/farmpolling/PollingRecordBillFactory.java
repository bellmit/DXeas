package com.kingdee.eas.custom.farmpolling;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PollingRecordBillFactory
{
    private PollingRecordBillFactory()
    {
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9CFC4C15") ,com.kingdee.eas.custom.farmpolling.IPollingRecordBill.class);
    }
    
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9CFC4C15") ,com.kingdee.eas.custom.farmpolling.IPollingRecordBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9CFC4C15"));
    }
    public static com.kingdee.eas.custom.farmpolling.IPollingRecordBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.farmpolling.IPollingRecordBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9CFC4C15"));
    }
}