package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ccCheckBillFacadeFactory
{
    private ccCheckBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E53DE1E1") ,com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E53DE1E1") ,com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E53DE1E1"));
    }
    public static com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IccCheckBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E53DE1E1"));
    }
}