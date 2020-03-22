package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderApplyBillFactory
{
    private FodderApplyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("37E98DBA") ,com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("37E98DBA") ,com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("37E98DBA"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderApplyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("37E98DBA"));
    }
}