package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WgtDisRateEntryFactory
{
    private WgtDisRateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("004B2352") ,com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("004B2352") ,com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("004B2352"));
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtDisRateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("004B2352"));
    }
}