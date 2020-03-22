package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginInitBillFactory
{
    private MarginInitBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E71455C") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E71455C") ,com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E71455C"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMarginInitBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E71455C"));
    }
}