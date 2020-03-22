package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QuitWagesBillEntryFactory
{
    private QuitWagesBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IQuitWagesBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1F3D32D7") ,com.kingdee.eas.custom.wages.IQuitWagesBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IQuitWagesBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1F3D32D7") ,com.kingdee.eas.custom.wages.IQuitWagesBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IQuitWagesBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1F3D32D7"));
    }
    public static com.kingdee.eas.custom.wages.IQuitWagesBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1F3D32D7"));
    }
}