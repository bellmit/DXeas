package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BailAmountFactory
{
    private BailAmountFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IBailAmount getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBailAmount)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("694FB4B6") ,com.kingdee.eas.custom.taihe.contract.IBailAmount.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IBailAmount getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBailAmount)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("694FB4B6") ,com.kingdee.eas.custom.taihe.contract.IBailAmount.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IBailAmount getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBailAmount)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("694FB4B6"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IBailAmount getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBailAmount)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("694FB4B6"));
    }
}