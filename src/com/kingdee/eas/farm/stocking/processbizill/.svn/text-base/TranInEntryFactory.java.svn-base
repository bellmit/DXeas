package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TranInEntryFactory
{
    private TranInEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranInEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranInEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4803EC1D") ,com.kingdee.eas.farm.stocking.processbizill.ITranInEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITranInEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranInEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4803EC1D") ,com.kingdee.eas.farm.stocking.processbizill.ITranInEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranInEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranInEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4803EC1D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITranInEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITranInEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4803EC1D"));
    }
}