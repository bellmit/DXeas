package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassRateDisEntryFactory
{
    private CarcassRateDisEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C1002C25") ,com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C1002C25") ,com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C1002C25"));
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateDisEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C1002C25"));
    }
}