package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoproductBillEntryFactory
{
    private CoproductBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3B96910D") ,com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3B96910D") ,com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3B96910D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICoproductBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3B96910D"));
    }
}