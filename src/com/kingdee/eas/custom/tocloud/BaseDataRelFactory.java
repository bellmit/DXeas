package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseDataRelFactory
{
    private BaseDataRelFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FDC6EBC5") ,com.kingdee.eas.custom.tocloud.IBaseDataRel.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBaseDataRel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FDC6EBC5") ,com.kingdee.eas.custom.tocloud.IBaseDataRel.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FDC6EBC5"));
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FDC6EBC5"));
    }
}