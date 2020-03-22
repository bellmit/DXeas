package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleConditionsEntryFactory
{
    private SaleConditionsEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FDE8DCC6") ,com.kingdee.eas.custom.lhsm.ISaleConditionsEntry.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FDE8DCC6") ,com.kingdee.eas.custom.lhsm.ISaleConditionsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FDE8DCC6"));
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditionsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditionsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FDE8DCC6"));
    }
}