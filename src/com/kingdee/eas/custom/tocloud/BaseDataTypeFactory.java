package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BaseDataTypeFactory
{
    private BaseDataTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BB17C18E") ,com.kingdee.eas.custom.tocloud.IBaseDataType.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBaseDataType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BB17C18E") ,com.kingdee.eas.custom.tocloud.IBaseDataType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BB17C18E"));
    }
    public static com.kingdee.eas.custom.tocloud.IBaseDataType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBaseDataType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BB17C18E"));
    }
}