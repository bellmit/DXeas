package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyImmuneEntryFactory
{
    private CCPigDailyImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7731A664") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7731A664") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7731A664"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7731A664"));
    }
}