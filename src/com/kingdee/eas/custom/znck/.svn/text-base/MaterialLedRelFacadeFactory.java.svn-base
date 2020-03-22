package com.kingdee.eas.custom.znck;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialLedRelFacadeFactory
{
    private MaterialLedRelFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRelFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CCF96F76") ,com.kingdee.eas.custom.znck.IMaterialLedRelFacade.class);
    }
    
    public static com.kingdee.eas.custom.znck.IMaterialLedRelFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CCF96F76") ,com.kingdee.eas.custom.znck.IMaterialLedRelFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRelFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CCF96F76"));
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRelFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CCF96F76"));
    }
}