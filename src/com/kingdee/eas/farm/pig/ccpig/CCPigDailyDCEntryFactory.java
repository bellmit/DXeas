package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyDCEntryFactory
{
    private CCPigDailyDCEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ABDDF288") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ABDDF288") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ABDDF288"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyDCEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ABDDF288"));
    }
}