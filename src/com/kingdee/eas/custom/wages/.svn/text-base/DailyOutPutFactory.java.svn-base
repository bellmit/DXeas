package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DailyOutPutFactory
{
    private DailyOutPutFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IDailyOutPut getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPut)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8CDF0352") ,com.kingdee.eas.custom.wages.IDailyOutPut.class);
    }
    
    public static com.kingdee.eas.custom.wages.IDailyOutPut getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPut)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8CDF0352") ,com.kingdee.eas.custom.wages.IDailyOutPut.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IDailyOutPut getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPut)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8CDF0352"));
    }
    public static com.kingdee.eas.custom.wages.IDailyOutPut getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IDailyOutPut)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8CDF0352"));
    }
}