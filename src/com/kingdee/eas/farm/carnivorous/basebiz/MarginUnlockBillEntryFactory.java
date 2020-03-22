package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginUnlockBillEntryFactory
{
    private MarginUnlockBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FE69BA02") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FE69BA02") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FE69BA02"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FE69BA02"));
    }
}