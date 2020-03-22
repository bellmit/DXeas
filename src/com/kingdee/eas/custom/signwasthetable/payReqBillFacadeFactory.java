package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class payReqBillFacadeFactory
{
    private payReqBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DA7FB9E1") ,com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DA7FB9E1") ,com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DA7FB9E1"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IpayReqBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DA7FB9E1"));
    }
}