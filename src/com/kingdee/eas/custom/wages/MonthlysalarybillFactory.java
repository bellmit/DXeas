package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthlysalarybillFactory
{
    private MonthlysalarybillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IMonthlysalarybill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3FD9D196") ,com.kingdee.eas.custom.wages.IMonthlysalarybill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IMonthlysalarybill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3FD9D196") ,com.kingdee.eas.custom.wages.IMonthlysalarybill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IMonthlysalarybill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3FD9D196"));
    }
    public static com.kingdee.eas.custom.wages.IMonthlysalarybill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IMonthlysalarybill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3FD9D196"));
    }
}