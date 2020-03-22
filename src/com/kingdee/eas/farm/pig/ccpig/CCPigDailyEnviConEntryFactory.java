package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyEnviConEntryFactory
{
    private CCPigDailyEnviConEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6A5F0B37") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6A5F0B37") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6A5F0B37"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyEnviConEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6A5F0B37"));
    }
}