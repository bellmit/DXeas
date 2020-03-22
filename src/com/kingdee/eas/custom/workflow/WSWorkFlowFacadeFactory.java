package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSWorkFlowFacadeFactory
{
    private WSWorkFlowFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("58F23959") ,com.kingdee.eas.custom.workflow.IWSWorkFlowFacade.class);
    }
    
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("58F23959") ,com.kingdee.eas.custom.workflow.IWSWorkFlowFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("58F23959"));
    }
    public static com.kingdee.eas.custom.workflow.IWSWorkFlowFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSWorkFlowFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("58F23959"));
    }
}