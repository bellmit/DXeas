package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillAssEntryFactory
{
    private SettleBillAssEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillAssEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillAssEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D353B634") ,com.kingdee.eas.custom.settlebill.ISettleBillAssEntry.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBillAssEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillAssEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D353B634") ,com.kingdee.eas.custom.settlebill.ISettleBillAssEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillAssEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillAssEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D353B634"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillAssEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillAssEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D353B634"));
    }
}