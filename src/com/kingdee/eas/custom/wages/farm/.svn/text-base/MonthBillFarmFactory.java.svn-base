package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthBillFarmFactory
{
    private MonthBillFarmFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("36C77F93") ,com.kingdee.eas.custom.wages.farm.IMonthBillFarm.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("36C77F93") ,com.kingdee.eas.custom.wages.farm.IMonthBillFarm.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("36C77F93"));
    }
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("36C77F93"));
    }
}