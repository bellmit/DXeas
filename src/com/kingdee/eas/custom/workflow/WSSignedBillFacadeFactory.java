package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSSignedBillFacadeFactory
{
    private WSSignedBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.workflow.IWSSignedBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSSignedBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("15696BBD") ,com.kingdee.eas.custom.workflow.IWSSignedBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.workflow.IWSSignedBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSSignedBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("15696BBD") ,com.kingdee.eas.custom.workflow.IWSSignedBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.workflow.IWSSignedBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSSignedBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("15696BBD"));
    }
    public static com.kingdee.eas.custom.workflow.IWSSignedBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSSignedBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("15696BBD"));
    }
}