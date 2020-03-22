package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class YieldDataBaseDisRateEntryFactory
{
    private YieldDataBaseDisRateEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("300AEF8A") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("300AEF8A") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("300AEF8A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseDisRateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("300AEF8A"));
    }
}