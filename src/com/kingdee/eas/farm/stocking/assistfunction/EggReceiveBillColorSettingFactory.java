package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggReceiveBillColorSettingFactory
{
    private EggReceiveBillColorSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1BD419D") ,com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting.class);
    }
    
    public static com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1BD419D") ,com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1BD419D"));
    }
    public static com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.IEggReceiveBillColorSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1BD419D"));
    }
}