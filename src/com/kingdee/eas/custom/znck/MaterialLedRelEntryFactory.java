package com.kingdee.eas.custom.znck;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialLedRelEntryFactory
{
    private MaterialLedRelEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A37BFE16") ,com.kingdee.eas.custom.znck.IMaterialLedRelEntry.class);
    }
    
    public static com.kingdee.eas.custom.znck.IMaterialLedRelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A37BFE16") ,com.kingdee.eas.custom.znck.IMaterialLedRelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A37BFE16"));
    }
    public static com.kingdee.eas.custom.znck.IMaterialLedRelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.znck.IMaterialLedRelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A37BFE16"));
    }
}