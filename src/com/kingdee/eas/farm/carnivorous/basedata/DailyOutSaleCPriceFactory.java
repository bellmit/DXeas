package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyOutSaleCPriceFactory
{
    private DailyOutSaleCPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E3F55344") ,com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E3F55344") ,com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E3F55344"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E3F55344"));
    }
}