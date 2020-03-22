package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TranOutEntryFactory
{
    private TranOutEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E7FB91F4") ,com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E7FB91F4") ,com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E7FB91F4"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranOutEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E7FB91F4"));
    }
}