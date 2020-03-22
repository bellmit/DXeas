package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CyxKbSettingEntryFactory
{
    private CyxKbSettingEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EAB1758C") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EAB1758C") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EAB1758C"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSettingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EAB1758C"));
    }
}