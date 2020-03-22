package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseDataTypeTreeFactory
{
    private BaseDataTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF48324C") ,com.kingdee.eas.custom.tocloud.IBaseDataTypeTree.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBaseDataTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF48324C") ,com.kingdee.eas.custom.tocloud.IBaseDataTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF48324C"));
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF48324C"));
    }
}