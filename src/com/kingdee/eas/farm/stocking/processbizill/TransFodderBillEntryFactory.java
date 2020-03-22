package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransFodderBillEntryFactory
{
    private TransFodderBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4A9502F2") ,com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4A9502F2") ,com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4A9502F2"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4A9502F2"));
    }
}