package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SocialwelfareEntryFactory
{
    private SocialwelfareEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.ISocialwelfareEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfareEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("49FA113B") ,com.kingdee.eas.custom.wages.ISocialwelfareEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.ISocialwelfareEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfareEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("49FA113B") ,com.kingdee.eas.custom.wages.ISocialwelfareEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.ISocialwelfareEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfareEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("49FA113B"));
    }
    public static com.kingdee.eas.custom.wages.ISocialwelfareEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.ISocialwelfareEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("49FA113B"));
    }
}