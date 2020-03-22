package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QCEggScrapBillFactory
{
    private QCEggScrapBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("03DB4AAA") ,com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("03DB4AAA") ,com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("03DB4AAA"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQCEggScrapBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("03DB4AAA"));
    }
}