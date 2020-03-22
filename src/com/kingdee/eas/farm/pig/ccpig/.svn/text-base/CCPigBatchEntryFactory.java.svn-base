package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBatchEntryFactory
{
    private CCPigBatchEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("87FDE866") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("87FDE866") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("87FDE866"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("87FDE866"));
    }
}