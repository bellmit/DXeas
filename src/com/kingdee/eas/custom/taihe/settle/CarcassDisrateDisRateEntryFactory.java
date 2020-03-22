package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassDisrateDisRateEntryFactory
{
    private CarcassDisrateDisRateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("33407B23") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("33407B23") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("33407B23"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateDisRateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("33407B23"));
    }
}