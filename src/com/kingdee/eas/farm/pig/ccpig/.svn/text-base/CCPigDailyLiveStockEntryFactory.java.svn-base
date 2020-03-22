package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyLiveStockEntryFactory
{
    private CCPigDailyLiveStockEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3CCA5C33") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3CCA5C33") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3CCA5C33"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyLiveStockEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3CCA5C33"));
    }
}