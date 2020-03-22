package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyOutEntryFactory
{
    private CCPigDailyOutEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E9742D2F") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E9742D2F") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E9742D2F"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyOutEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E9742D2F"));
    }
}