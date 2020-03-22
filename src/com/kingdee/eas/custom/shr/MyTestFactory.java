package com.kingdee.eas.custom.shr;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MyTestFactory
{
    private MyTestFactory()
    {
    }
    public static com.kingdee.eas.custom.shr.IMyTest getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTest)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8B4D60B4") ,com.kingdee.eas.custom.shr.IMyTest.class);
    }
    
    public static com.kingdee.eas.custom.shr.IMyTest getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTest)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8B4D60B4") ,com.kingdee.eas.custom.shr.IMyTest.class, objectCtx);
    }
    public static com.kingdee.eas.custom.shr.IMyTest getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTest)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8B4D60B4"));
    }
    public static com.kingdee.eas.custom.shr.IMyTest getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.shr.IMyTest)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8B4D60B4"));
    }
}