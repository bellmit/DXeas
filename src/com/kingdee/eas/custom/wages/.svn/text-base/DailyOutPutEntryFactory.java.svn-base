package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyOutPutEntryFactory
{
    private DailyOutPutEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IDailyOutPutEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPutEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("54F85840") ,com.kingdee.eas.custom.wages.IDailyOutPutEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IDailyOutPutEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPutEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("54F85840") ,com.kingdee.eas.custom.wages.IDailyOutPutEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IDailyOutPutEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPutEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("54F85840"));
    }
    public static com.kingdee.eas.custom.wages.IDailyOutPutEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPutEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("54F85840"));
    }
}