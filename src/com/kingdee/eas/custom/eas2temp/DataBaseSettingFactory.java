package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DataBaseSettingFactory
{
    private DataBaseSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2F6377E1") ,com.kingdee.eas.custom.eas2temp.IDataBaseSetting.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2F6377E1") ,com.kingdee.eas.custom.eas2temp.IDataBaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2F6377E1"));
    }
    public static com.kingdee.eas.custom.eas2temp.IDataBaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IDataBaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2F6377E1"));
    }
}