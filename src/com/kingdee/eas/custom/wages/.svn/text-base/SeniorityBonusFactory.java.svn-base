package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SeniorityBonusFactory
{
    private SeniorityBonusFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.ISeniorityBonus getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonus)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D12E8049") ,com.kingdee.eas.custom.wages.ISeniorityBonus.class);
    }
    
    public static com.kingdee.eas.custom.wages.ISeniorityBonus getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonus)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D12E8049") ,com.kingdee.eas.custom.wages.ISeniorityBonus.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.ISeniorityBonus getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonus)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D12E8049"));
    }
    public static com.kingdee.eas.custom.wages.ISeniorityBonus getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISeniorityBonus)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D12E8049"));
    }
}