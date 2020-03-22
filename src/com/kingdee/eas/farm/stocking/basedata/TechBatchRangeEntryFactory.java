package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TechBatchRangeEntryFactory
{
    private TechBatchRangeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7D17BFA8") ,com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7D17BFA8") ,com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7D17BFA8"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRangeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7D17BFA8"));
    }
}