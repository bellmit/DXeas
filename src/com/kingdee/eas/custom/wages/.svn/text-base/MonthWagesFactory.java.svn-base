package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthWagesFactory
{
    private MonthWagesFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IMonthWages getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWages)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B43603B3") ,com.kingdee.eas.custom.wages.IMonthWages.class);
    }
    
    public static com.kingdee.eas.custom.wages.IMonthWages getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWages)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B43603B3") ,com.kingdee.eas.custom.wages.IMonthWages.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IMonthWages getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWages)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B43603B3"));
    }
    public static com.kingdee.eas.custom.wages.IMonthWages getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthWages)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B43603B3"));
    }
}