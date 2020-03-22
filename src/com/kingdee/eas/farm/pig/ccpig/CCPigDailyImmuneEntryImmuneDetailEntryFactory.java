package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyImmuneEntryImmuneDetailEntryFactory
{
    private CCPigDailyImmuneEntryImmuneDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("080AD41A") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("080AD41A") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("080AD41A"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("080AD41A"));
    }
}