package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransBirdsBillEntryFactory
{
    private TransBirdsBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("803F1434") ,com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("803F1434") ,com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("803F1434"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransBirdsBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("803F1434"));
    }
}