package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SupplierReqFactory
{
    private SupplierReqFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.ISupplierReq getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReq)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("034B4A5B") ,com.kingdee.eas.bdm.bdapply.ISupplierReq.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.ISupplierReq getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReq)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("034B4A5B") ,com.kingdee.eas.bdm.bdapply.ISupplierReq.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.ISupplierReq getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReq)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("034B4A5B"));
    }
    public static com.kingdee.eas.bdm.bdapply.ISupplierReq getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ISupplierReq)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("034B4A5B"));
    }
}