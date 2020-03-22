package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillEntryFactory
{
    private SettleBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D70278F") ,com.kingdee.eas.custom.settlebill.ISettleBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D70278F") ,com.kingdee.eas.custom.settlebill.ISettleBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D70278F"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D70278F"));
    }
}