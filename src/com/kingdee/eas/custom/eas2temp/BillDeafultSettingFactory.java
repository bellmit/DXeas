package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BillDeafultSettingFactory
{
    private BillDeafultSettingFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3EF1474") ,com.kingdee.eas.custom.eas2temp.IBillDeafultSetting.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3EF1474") ,com.kingdee.eas.custom.eas2temp.IBillDeafultSetting.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3EF1474"));
    }
    public static com.kingdee.eas.custom.eas2temp.IBillDeafultSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IBillDeafultSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3EF1474"));
    }
}