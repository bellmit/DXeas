package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthBillFarmEntryFactory
{
    private MonthBillFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A3E85C9F") ,com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A3E85C9F") ,com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A3E85C9F"));
    }
    public static com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMonthBillFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A3E85C9F"));
    }
}