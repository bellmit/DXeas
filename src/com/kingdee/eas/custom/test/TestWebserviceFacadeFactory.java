package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TestWebserviceFacadeFactory
{
    private TestWebserviceFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.test.ITestWebserviceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.ITestWebserviceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("47C9643E") ,com.kingdee.eas.custom.test.ITestWebserviceFacade.class);
    }
    
    public static com.kingdee.eas.custom.test.ITestWebserviceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ITestWebserviceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("47C9643E") ,com.kingdee.eas.custom.test.ITestWebserviceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.ITestWebserviceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ITestWebserviceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("47C9643E"));
    }
    public static com.kingdee.eas.custom.test.ITestWebserviceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.ITestWebserviceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("47C9643E"));
    }
}