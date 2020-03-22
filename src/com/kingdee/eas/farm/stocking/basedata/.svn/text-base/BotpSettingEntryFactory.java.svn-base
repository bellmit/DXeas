package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BotpSettingEntryFactory
{
    private BotpSettingEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A7273F7C") ,com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A7273F7C") ,com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A7273F7C"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBotpSettingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A7273F7C"));
    }
}