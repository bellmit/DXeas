package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QCEggScrapBillEntryFactory
{
    private QCEggScrapBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("99BAE7E8") ,com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("99BAE7E8") ,com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("99BAE7E8"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("99BAE7E8"));
    }
}