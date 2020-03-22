package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TestWebServiceFacadeFactory
{
    private TestWebServiceFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("53CDF052") ,com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("53CDF052") ,com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("53CDF052"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITestWebServiceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("53CDF052"));
    }
}