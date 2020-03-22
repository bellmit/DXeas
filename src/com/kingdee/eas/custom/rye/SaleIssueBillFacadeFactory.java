package com.kingdee.eas.custom.rye;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleIssueBillFacadeFactory
{
    private SaleIssueBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.rye.ISaleIssueBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rye.ISaleIssueBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4CCAE09E") ,com.kingdee.eas.custom.rye.ISaleIssueBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.rye.ISaleIssueBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.ISaleIssueBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4CCAE09E") ,com.kingdee.eas.custom.rye.ISaleIssueBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rye.ISaleIssueBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.ISaleIssueBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4CCAE09E"));
    }
    public static com.kingdee.eas.custom.rye.ISaleIssueBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.ISaleIssueBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4CCAE09E"));
    }
}