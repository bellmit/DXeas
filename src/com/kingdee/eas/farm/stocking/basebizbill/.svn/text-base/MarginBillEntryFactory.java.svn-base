package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginBillEntryFactory
{
    private MarginBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9710199C") ,com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9710199C") ,com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9710199C"));
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9710199C"));
    }
}