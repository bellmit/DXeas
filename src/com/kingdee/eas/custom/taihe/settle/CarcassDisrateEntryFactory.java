package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassDisrateEntryFactory
{
    private CarcassDisrateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("16F124B3") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("16F124B3") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("16F124B3"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("16F124B3"));
    }
}