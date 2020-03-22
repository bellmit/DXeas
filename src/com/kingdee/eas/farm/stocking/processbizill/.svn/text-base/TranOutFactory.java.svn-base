package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TranOutFactory
{
    private TranOutFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOut getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOut)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4103891E") ,com.kingdee.eas.farm.stocking.processbizill.ITranOut.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOut getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOut)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4103891E") ,com.kingdee.eas.farm.stocking.processbizill.ITranOut.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOut getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOut)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4103891E"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOut getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOut)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4103891E"));
    }
}