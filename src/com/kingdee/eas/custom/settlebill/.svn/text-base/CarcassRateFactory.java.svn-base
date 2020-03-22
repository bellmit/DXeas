package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassRateFactory
{
    private CarcassRateFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRate getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRate)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E8649C81") ,com.kingdee.eas.custom.settlebill.ICarcassRate.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ICarcassRate getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRate)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E8649C81") ,com.kingdee.eas.custom.settlebill.ICarcassRate.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRate getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRate)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E8649C81"));
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRate getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRate)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E8649C81"));
    }
}