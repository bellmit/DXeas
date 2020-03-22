package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassRateEntryFactory
{
    private CarcassRateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CA3E2471") ,com.kingdee.eas.custom.settlebill.ICarcassRateEntry.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ICarcassRateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CA3E2471") ,com.kingdee.eas.custom.settlebill.ICarcassRateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CA3E2471"));
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CA3E2471"));
    }
}