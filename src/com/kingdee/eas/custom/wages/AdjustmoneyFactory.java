package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AdjustmoneyFactory
{
    private AdjustmoneyFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IAdjustmoney getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoney)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E7879989") ,com.kingdee.eas.custom.wages.IAdjustmoney.class);
    }
    
    public static com.kingdee.eas.custom.wages.IAdjustmoney getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoney)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E7879989") ,com.kingdee.eas.custom.wages.IAdjustmoney.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IAdjustmoney getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoney)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E7879989"));
    }
    public static com.kingdee.eas.custom.wages.IAdjustmoney getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IAdjustmoney)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E7879989"));
    }
}