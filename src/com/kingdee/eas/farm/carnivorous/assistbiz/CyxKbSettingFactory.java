package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CyxKbSettingFactory
{
    private CyxKbSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8363C686") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8363C686") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8363C686"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICyxKbSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8363C686"));
    }
}