package com.kingdee.eas.custom.settleaccount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class settleAccountFacadeFactory
{
    private settleAccountFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.settleaccount.IsettleAccountFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settleaccount.IsettleAccountFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6059DDEB") ,com.kingdee.eas.custom.settleaccount.IsettleAccountFacade.class);
    }
    
    public static com.kingdee.eas.custom.settleaccount.IsettleAccountFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settleaccount.IsettleAccountFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6059DDEB") ,com.kingdee.eas.custom.settleaccount.IsettleAccountFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settleaccount.IsettleAccountFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settleaccount.IsettleAccountFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6059DDEB"));
    }
    public static com.kingdee.eas.custom.settleaccount.IsettleAccountFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settleaccount.IsettleAccountFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6059DDEB"));
    }
}