package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BillUpdateLogFactory
{
    private BillUpdateLogFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLog getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLog)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA9B08B5") ,com.kingdee.eas.wlhlcomm.function.IBillUpdateLog.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLog getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLog)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA9B08B5") ,com.kingdee.eas.wlhlcomm.function.IBillUpdateLog.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLog getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLog)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA9B08B5"));
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLog getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLog)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA9B08B5"));
    }
}