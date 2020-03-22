package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FractionOtherBillFactory
{
    private FractionOtherBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IFractionOtherBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CEA1C44D") ,com.kingdee.eas.custom.wages.IFractionOtherBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IFractionOtherBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CEA1C44D") ,com.kingdee.eas.custom.wages.IFractionOtherBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IFractionOtherBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CEA1C44D"));
    }
    public static com.kingdee.eas.custom.wages.IFractionOtherBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IFractionOtherBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CEA1C44D"));
    }
}