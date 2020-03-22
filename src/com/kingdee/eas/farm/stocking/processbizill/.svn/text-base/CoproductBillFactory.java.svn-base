package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoproductBillFactory
{
    private CoproductBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BF29BE65") ,com.kingdee.eas.farm.stocking.processbizill.ICoproductBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BF29BE65") ,com.kingdee.eas.farm.stocking.processbizill.ICoproductBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BF29BE65"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BF29BE65"));
    }
}