package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleReFactory
{
    private SettleReFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.ISettleRe getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleRe)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6DA10F7F") ,com.kingdee.eas.custom.dx.weight.ISettleRe.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.ISettleRe getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleRe)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6DA10F7F") ,com.kingdee.eas.custom.dx.weight.ISettleRe.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.ISettleRe getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleRe)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6DA10F7F"));
    }
    public static com.kingdee.eas.custom.dx.weight.ISettleRe getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleRe)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6DA10F7F"));
    }
}