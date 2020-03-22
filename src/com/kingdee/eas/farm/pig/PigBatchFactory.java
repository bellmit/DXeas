package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigBatchFactory
{
    private PigBatchFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigBatch getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatch)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FEF6F88C") ,com.kingdee.eas.farm.pig.IPigBatch.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigBatch getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatch)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FEF6F88C") ,com.kingdee.eas.farm.pig.IPigBatch.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigBatch getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatch)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FEF6F88C"));
    }
    public static com.kingdee.eas.farm.pig.IPigBatch getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatch)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FEF6F88C"));
    }
}