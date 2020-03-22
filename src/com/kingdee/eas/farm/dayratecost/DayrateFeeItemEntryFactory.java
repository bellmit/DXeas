package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayrateFeeItemEntryFactory
{
    private DayrateFeeItemEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8EC15B50") ,com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8EC15B50") ,com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8EC15B50"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8EC15B50"));
    }
}