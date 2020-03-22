package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ChargeBackStdFactory
{
    private ChargeBackStdFactory()
    {
    }
    public static com.kingdee.eas.custom.ccchargeback.IChargeBackStd getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IChargeBackStd)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6E4B5E00") ,com.kingdee.eas.custom.ccchargeback.IChargeBackStd.class);
    }
    
    public static com.kingdee.eas.custom.ccchargeback.IChargeBackStd getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IChargeBackStd)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6E4B5E00") ,com.kingdee.eas.custom.ccchargeback.IChargeBackStd.class, objectCtx);
    }
    public static com.kingdee.eas.custom.ccchargeback.IChargeBackStd getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IChargeBackStd)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6E4B5E00"));
    }
    public static com.kingdee.eas.custom.ccchargeback.IChargeBackStd getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.IChargeBackStd)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6E4B5E00"));
    }
}