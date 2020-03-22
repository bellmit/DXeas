package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayRateBaseSettingFactory
{
    private DayRateBaseSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("11CFDC28") ,com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("11CFDC28") ,com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("11CFDC28"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("11CFDC28"));
    }
}