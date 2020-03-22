package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleConditionsFactory
{
    private SaleConditionsFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditions getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditions)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2D23430C") ,com.kingdee.eas.custom.lhsm.ISaleConditions.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.ISaleConditions getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditions)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2D23430C") ,com.kingdee.eas.custom.lhsm.ISaleConditions.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditions getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditions)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2D23430C"));
    }
    public static com.kingdee.eas.custom.lhsm.ISaleConditions getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.ISaleConditions)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2D23430C"));
    }
}