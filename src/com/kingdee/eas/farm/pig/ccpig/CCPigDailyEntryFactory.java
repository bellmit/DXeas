package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyEntryFactory
{
    private CCPigDailyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F2FE54E7") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F2FE54E7") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F2FE54E7"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F2FE54E7"));
    }
}