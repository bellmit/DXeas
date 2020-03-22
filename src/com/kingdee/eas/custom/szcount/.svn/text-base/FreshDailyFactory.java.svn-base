package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreshDailyFactory
{
    private FreshDailyFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IFreshDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("19270D36") ,com.kingdee.eas.custom.szcount.IFreshDaily.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IFreshDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("19270D36") ,com.kingdee.eas.custom.szcount.IFreshDaily.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IFreshDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("19270D36"));
    }
    public static com.kingdee.eas.custom.szcount.IFreshDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IFreshDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("19270D36"));
    }
}