package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigBatchTypeFactory
{
    private PigBatchTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigBatchType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4297D5E6") ,com.kingdee.eas.farm.pig.IPigBatchType.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigBatchType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4297D5E6") ,com.kingdee.eas.farm.pig.IPigBatchType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigBatchType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4297D5E6"));
    }
    public static com.kingdee.eas.farm.pig.IPigBatchType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4297D5E6"));
    }
}