package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginUnlockBillFactory
{
    private MarginUnlockBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92241050") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92241050") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92241050"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginUnlockBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92241050"));
    }
}