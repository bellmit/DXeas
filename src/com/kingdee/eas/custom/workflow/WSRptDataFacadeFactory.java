package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSRptDataFacadeFactory
{
    private WSRptDataFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.workflow.IWSRptDataFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSRptDataFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("296E4B7A") ,com.kingdee.eas.custom.workflow.IWSRptDataFacade.class);
    }
    
    public static com.kingdee.eas.custom.workflow.IWSRptDataFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSRptDataFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("296E4B7A") ,com.kingdee.eas.custom.workflow.IWSRptDataFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.workflow.IWSRptDataFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSRptDataFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("296E4B7A"));
    }
    public static com.kingdee.eas.custom.workflow.IWSRptDataFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSRptDataFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("296E4B7A"));
    }
}