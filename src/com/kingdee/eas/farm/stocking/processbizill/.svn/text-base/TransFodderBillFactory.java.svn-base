package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TransFodderBillFactory
{
    private TransFodderBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AF6AF160") ,com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AF6AF160") ,com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AF6AF160"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITransFodderBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AF6AF160"));
    }
}