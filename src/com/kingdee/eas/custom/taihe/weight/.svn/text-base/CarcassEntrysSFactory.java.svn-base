package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassEntrysSFactory
{
    private CarcassEntrysSFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C3E8C076") ,com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C3E8C076") ,com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C3E8C076"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarcassEntrysS)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C3E8C076"));
    }
}