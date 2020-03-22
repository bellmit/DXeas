package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginBillFactory
{
    private MarginBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3052D876") ,com.kingdee.eas.farm.stocking.basebizbill.IMarginBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3052D876") ,com.kingdee.eas.farm.stocking.basebizbill.IMarginBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3052D876"));
    }
    public static com.kingdee.eas.farm.stocking.basebizbill.IMarginBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.IMarginBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3052D876"));
    }
}