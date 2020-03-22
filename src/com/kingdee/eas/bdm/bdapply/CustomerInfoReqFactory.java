package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerInfoReqFactory
{
    private CustomerInfoReqFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReq getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReq)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8CE1C1FB") ,com.kingdee.eas.bdm.bdapply.ICustomerInfoReq.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReq getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReq)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8CE1C1FB") ,com.kingdee.eas.bdm.bdapply.ICustomerInfoReq.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReq getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReq)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8CE1C1FB"));
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReq getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReq)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8CE1C1FB"));
    }
}