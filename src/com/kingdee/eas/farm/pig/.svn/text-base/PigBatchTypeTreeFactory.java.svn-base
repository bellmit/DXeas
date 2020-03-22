package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigBatchTypeTreeFactory
{
    private PigBatchTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigBatchTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E5765AA4") ,com.kingdee.eas.farm.pig.IPigBatchTypeTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigBatchTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E5765AA4") ,com.kingdee.eas.farm.pig.IPigBatchTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigBatchTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E5765AA4"));
    }
    public static com.kingdee.eas.farm.pig.IPigBatchTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E5765AA4"));
    }
}