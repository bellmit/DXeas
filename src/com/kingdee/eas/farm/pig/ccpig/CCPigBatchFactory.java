package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBatchFactory
{
    private CCPigBatchFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatch getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatch)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BFBD736C") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatch.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatch getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatch)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BFBD736C") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatch.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatch getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatch)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BFBD736C"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatch getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatch)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BFBD736C"));
    }
}