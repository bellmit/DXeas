package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AssureAmtPolicyFactory
{
    private AssureAmtPolicyFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8D77C2F7") ,com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8D77C2F7") ,com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8D77C2F7"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8D77C2F7"));
    }
}