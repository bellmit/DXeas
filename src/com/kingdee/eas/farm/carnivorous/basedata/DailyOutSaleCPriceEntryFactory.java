package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyOutSaleCPriceEntryFactory
{
    private DailyOutSaleCPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67702F8E") ,com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67702F8E") ,com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67702F8E"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67702F8E"));
    }
}