package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseDataRelTreeFactory
{
    private BaseDataRelTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A5596903") ,com.kingdee.eas.custom.tocloud.IBaseDataRelTree.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A5596903") ,com.kingdee.eas.custom.tocloud.IBaseDataRelTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A5596903"));
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A5596903"));
    }
}