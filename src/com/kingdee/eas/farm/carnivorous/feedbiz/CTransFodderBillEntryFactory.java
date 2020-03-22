package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CTransFodderBillEntryFactory
{
    private CTransFodderBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BCC3AD2C") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BCC3AD2C") ,com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BCC3AD2C"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ICTransFodderBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BCC3AD2C"));
    }
}