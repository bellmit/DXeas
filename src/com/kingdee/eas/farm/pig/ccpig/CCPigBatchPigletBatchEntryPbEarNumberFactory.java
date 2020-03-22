package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBatchPigletBatchEntryPbEarNumberFactory
{
    private CCPigBatchPigletBatchEntryPbEarNumberFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("47C2F91C") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("47C2F91C") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("47C2F91C"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigletBatchEntryPbEarNumber)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("47C2F91C"));
    }
}