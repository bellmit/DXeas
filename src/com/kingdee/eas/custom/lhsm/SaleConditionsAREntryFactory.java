package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleConditionsAREntryFactory
{
    private SaleConditionsAREntryFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("212BFE35") ,com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("212BFE35") ,com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("212BFE35"));
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsAREntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("212BFE35"));
    }
}