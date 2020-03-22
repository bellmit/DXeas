package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassRateDisRateEntryFactory
{
    private CarcassRateDisRateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D745E9A5") ,com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D745E9A5") ,com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D745E9A5"));
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisRateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D745E9A5"));
    }
}