package com.kingdee.eas.custom.taihe.server;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReturnBillFactory
{
    private ReturnBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.server.IReturnBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("76E5DBE2") ,com.kingdee.eas.custom.taihe.server.IReturnBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.server.IReturnBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("76E5DBE2") ,com.kingdee.eas.custom.taihe.server.IReturnBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.server.IReturnBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("76E5DBE2"));
    }
    public static com.kingdee.eas.custom.taihe.server.IReturnBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.server.IReturnBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("76E5DBE2"));
    }
}