package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SeedBillFactory
{
    private SeedBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CE1BCC7D") ,com.kingdee.eas.farm.stocking.processbizill.ISeedBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CE1BCC7D") ,com.kingdee.eas.farm.stocking.processbizill.ISeedBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CE1BCC7D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ISeedBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ISeedBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CE1BCC7D"));
    }
}