package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherReceptionBillFactory
{
    private OtherReceptionBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("01986E6B") ,com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("01986E6B") ,com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("01986E6B"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherReceptionBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("01986E6B"));
    }
}