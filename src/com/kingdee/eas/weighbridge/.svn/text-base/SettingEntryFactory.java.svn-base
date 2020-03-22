package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettingEntryFactory
{
    private SettingEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ISettingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1CBE335D") ,com.kingdee.eas.weighbridge.ISettingEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.ISettingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1CBE335D") ,com.kingdee.eas.weighbridge.ISettingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ISettingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1CBE335D"));
    }
    public static com.kingdee.eas.weighbridge.ISettingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1CBE335D"));
    }
}