package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AppealBillEntryFactory
{
    private AppealBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67C371D7") ,com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67C371D7") ,com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67C371D7"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67C371D7"));
    }
}