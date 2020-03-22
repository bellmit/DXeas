package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustCauseFactory
{
    private AdjustCauseFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAdjustCause getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCause)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E5317D12") ,com.kingdee.eas.custom.wages.IAdjustCause.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAdjustCause getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCause)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E5317D12") ,com.kingdee.eas.custom.wages.IAdjustCause.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAdjustCause getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCause)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E5317D12"));
    }
    public static com.kingdee.eas.custom.wages.IAdjustCause getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustCause)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E5317D12"));
    }
}