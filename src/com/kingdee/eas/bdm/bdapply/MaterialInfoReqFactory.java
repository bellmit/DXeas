package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialInfoReqFactory
{
    private MaterialInfoReqFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.IMaterialInfoReq getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IMaterialInfoReq)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("126A0892") ,com.kingdee.eas.bdm.bdapply.IMaterialInfoReq.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.IMaterialInfoReq getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IMaterialInfoReq)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("126A0892") ,com.kingdee.eas.bdm.bdapply.IMaterialInfoReq.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.IMaterialInfoReq getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IMaterialInfoReq)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("126A0892"));
    }
    public static com.kingdee.eas.bdm.bdapply.IMaterialInfoReq getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.IMaterialInfoReq)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("126A0892"));
    }
}