package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CTransFodderBillFactory
{
    private CTransFodderBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("77754AE6") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("77754AE6") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("77754AE6"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("77754AE6"));
    }
}