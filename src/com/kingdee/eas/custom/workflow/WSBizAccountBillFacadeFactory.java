package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSBizAccountBillFacadeFactory
{
    private WSBizAccountBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3497D0BB") ,com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3497D0BB") ,com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3497D0BB"));
    }
    public static com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3497D0BB"));
    }
}