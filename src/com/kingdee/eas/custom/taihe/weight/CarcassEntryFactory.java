package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassEntryFactory
{
    private CarcassEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C3BBC7B6") ,com.kingdee.eas.custom.taihe.weight.ICarcassEntry.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C3BBC7B6") ,com.kingdee.eas.custom.taihe.weight.ICarcassEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C3BBC7B6"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C3BBC7B6"));
    }
}