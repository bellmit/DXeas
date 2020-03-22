package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WagesPersonInfoEntryFactory
{
    private WagesPersonInfoEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWagesPersonInfoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B84190CC") ,com.kingdee.eas.custom.wages.IWagesPersonInfoEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWagesPersonInfoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B84190CC") ,com.kingdee.eas.custom.wages.IWagesPersonInfoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWagesPersonInfoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B84190CC"));
    }
    public static com.kingdee.eas.custom.wages.IWagesPersonInfoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWagesPersonInfoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B84190CC"));
    }
}