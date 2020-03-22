package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class UserReqFactory
{
    private UserReqFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.IUserReq getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IUserReq)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B10EA07C") ,com.kingdee.eas.bdm.bdapply.IUserReq.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.IUserReq getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IUserReq)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B10EA07C") ,com.kingdee.eas.bdm.bdapply.IUserReq.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.IUserReq getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IUserReq)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B10EA07C"));
    }
    public static com.kingdee.eas.bdm.bdapply.IUserReq getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IUserReq)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B10EA07C"));
    }
}