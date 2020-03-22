package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyCullEntryCullEarNumberEntryFactory
{
    private CCPigDailyCullEntryCullEarNumberEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B3FF087A") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B3FF087A") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B3FF087A"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntryCullEarNumberEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B3FF087A"));
    }
}