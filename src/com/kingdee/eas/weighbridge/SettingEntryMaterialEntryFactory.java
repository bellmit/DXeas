package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettingEntryMaterialEntryFactory
{
    private SettingEntryMaterialEntryFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2E6EEF2E") ,com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry.class);
    }
    
    public static com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2E6EEF2E") ,com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2E6EEF2E"));
    }
    public static com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.ISettingEntryMaterialEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2E6EEF2E"));
    }
}