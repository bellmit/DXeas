package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BillUpdateLogEntryFactory
{
    private BillUpdateLogEntryFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9DE738BD") ,com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9DE738BD") ,com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9DE738BD"));
    }
    public static com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.IBillUpdateLogEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9DE738BD"));
    }
}