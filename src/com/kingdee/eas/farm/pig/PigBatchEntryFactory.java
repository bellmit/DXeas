package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigBatchEntryFactory
{
    private PigBatchEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigBatchEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0F8A9746") ,com.kingdee.eas.farm.pig.IPigBatchEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigBatchEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0F8A9746") ,com.kingdee.eas.farm.pig.IPigBatchEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigBatchEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0F8A9746"));
    }
    public static com.kingdee.eas.farm.pig.IPigBatchEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigBatchEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0F8A9746"));
    }
}