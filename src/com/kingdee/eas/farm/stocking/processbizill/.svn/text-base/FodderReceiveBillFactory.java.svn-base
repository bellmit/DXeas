package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderReceiveBillFactory
{
    private FodderReceiveBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F330056F") ,com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F330056F") ,com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F330056F"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFodderReceiveBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F330056F"));
    }
}