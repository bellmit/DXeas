package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseDataRelEntryFactory
{
    private BaseDataRelEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("04FEBFAD") ,com.kingdee.eas.custom.tocloud.IBaseDataRelEntry.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("04FEBFAD") ,com.kingdee.eas.custom.tocloud.IBaseDataRelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("04FEBFAD"));
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataRelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataRelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("04FEBFAD"));
    }
}