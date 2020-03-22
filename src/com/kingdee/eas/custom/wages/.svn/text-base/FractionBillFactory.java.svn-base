package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FractionBillFactory
{
    private FractionBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IFractionBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("76451931") ,com.kingdee.eas.custom.wages.IFractionBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IFractionBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("76451931") ,com.kingdee.eas.custom.wages.IFractionBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IFractionBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("76451931"));
    }
    public static com.kingdee.eas.custom.wages.IFractionBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("76451931"));
    }
}