package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BizTypeFactory
{
    private BizTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.tocloud.IBizType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("80DBB9B4") ,com.kingdee.eas.custom.tocloud.IBizType.class);
    }
    
    public static com.kingdee.eas.custom.tocloud.IBizType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("80DBB9B4") ,com.kingdee.eas.custom.tocloud.IBizType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.tocloud.IBizType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("80DBB9B4"));
    }
    public static com.kingdee.eas.custom.tocloud.IBizType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.tocloud.IBizType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("80DBB9B4"));
    }
}