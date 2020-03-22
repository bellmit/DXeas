package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBatchPigletBatchEntryFactory
{
    private CCPigBatchPigletBatchEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BA55B291") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BA55B291") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BA55B291"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BA55B291"));
    }
}