package com.kingdee.eas.custom;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class payReqBillFacadeFactory
{
    private payReqBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.IpayReqBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.IpayReqBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E367431C") ,com.kingdee.eas.custom.IpayReqBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.IpayReqBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.IpayReqBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E367431C") ,com.kingdee.eas.custom.IpayReqBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.IpayReqBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.IpayReqBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E367431C"));
    }
    public static com.kingdee.eas.custom.IpayReqBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.IpayReqBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E367431C"));
    }
}