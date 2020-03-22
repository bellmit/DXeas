package com.kingdee.eas.custom.znck;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialLedRelFactory
{
    private MaterialLedRelFactory()
    {
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4AD48FBC") ,com.kingdee.eas.custom.znck.IMaterialLedRel.class);
    }
    
    public static com.kingdee.eas.custom.znck.IMaterialLedRel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4AD48FBC") ,com.kingdee.eas.custom.znck.IMaterialLedRel.class, objectCtx);
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4AD48FBC"));
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4AD48FBC"));
    }
}