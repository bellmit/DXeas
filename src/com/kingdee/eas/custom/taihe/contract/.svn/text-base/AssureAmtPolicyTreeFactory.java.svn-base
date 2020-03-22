package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AssureAmtPolicyTreeFactory
{
    private AssureAmtPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B5875735") ,com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B5875735") ,com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B5875735"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IAssureAmtPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B5875735"));
    }
}