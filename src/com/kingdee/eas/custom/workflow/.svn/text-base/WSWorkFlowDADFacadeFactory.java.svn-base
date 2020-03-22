package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSWorkFlowDADFacadeFactory
{
    private WSWorkFlowDADFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("091365E2") ,com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade.class);
    }
    
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("091365E2") ,com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("091365E2"));
    }
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("091365E2"));
    }
}