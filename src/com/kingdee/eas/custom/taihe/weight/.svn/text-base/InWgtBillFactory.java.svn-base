package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InWgtBillFactory
{
    private InWgtBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.IInWgtBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IInWgtBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B2478F70") ,com.kingdee.eas.custom.taihe.weight.IInWgtBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.IInWgtBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IInWgtBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B2478F70") ,com.kingdee.eas.custom.taihe.weight.IInWgtBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.IInWgtBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IInWgtBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B2478F70"));
    }
    public static com.kingdee.eas.custom.taihe.weight.IInWgtBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IInWgtBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B2478F70"));
    }
}