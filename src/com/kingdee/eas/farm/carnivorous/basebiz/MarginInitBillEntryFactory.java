package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginInitBillEntryFactory
{
    private MarginInitBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2F8FCC76") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2F8FCC76") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2F8FCC76"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2F8FCC76"));
    }
}