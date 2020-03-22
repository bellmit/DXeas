package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TechBatchRangeFactory
{
    private TechBatchRangeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRange getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRange)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9C469AEA") ,com.kingdee.eas.farm.stocking.basedata.ITechBatchRange.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRange getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRange)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9C469AEA") ,com.kingdee.eas.farm.stocking.basedata.ITechBatchRange.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRange getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRange)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9C469AEA"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ITechBatchRange getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ITechBatchRange)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9C469AEA"));
    }
}