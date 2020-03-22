package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigBatchEntryTagDetailFactory
{
    private PigBatchEntryTagDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AEBB7FE5") ,com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AEBB7FE5") ,com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AEBB7FE5"));
    }
    public static com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntryTagDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AEBB7FE5"));
    }
}