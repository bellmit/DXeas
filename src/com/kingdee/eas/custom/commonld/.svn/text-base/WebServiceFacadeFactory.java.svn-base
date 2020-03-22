package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WebServiceFacadeFactory
{
    private WebServiceFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.commonld.IWebServiceFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IWebServiceFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DF1B6C7B") ,com.kingdee.eas.custom.commonld.IWebServiceFacade.class);
    }
    
    public static com.kingdee.eas.custom.commonld.IWebServiceFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IWebServiceFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DF1B6C7B") ,com.kingdee.eas.custom.commonld.IWebServiceFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.commonld.IWebServiceFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IWebServiceFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DF1B6C7B"));
    }
    public static com.kingdee.eas.custom.commonld.IWebServiceFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IWebServiceFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DF1B6C7B"));
    }
}