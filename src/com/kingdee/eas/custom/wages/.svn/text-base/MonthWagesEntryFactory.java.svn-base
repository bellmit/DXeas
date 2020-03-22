package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthWagesEntryFactory
{
    private MonthWagesEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IMonthWagesEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWagesEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D1876C7F") ,com.kingdee.eas.custom.wages.IMonthWagesEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IMonthWagesEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWagesEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D1876C7F") ,com.kingdee.eas.custom.wages.IMonthWagesEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IMonthWagesEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWagesEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D1876C7F"));
    }
    public static com.kingdee.eas.custom.wages.IMonthWagesEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWagesEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D1876C7F"));
    }
}