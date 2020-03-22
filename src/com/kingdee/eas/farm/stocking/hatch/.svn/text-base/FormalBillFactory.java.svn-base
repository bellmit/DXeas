package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FormalBillFactory
{
    private FormalBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CF69E800") ,com.kingdee.eas.farm.stocking.hatch.IFormalBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CF69E800") ,com.kingdee.eas.farm.stocking.hatch.IFormalBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CF69E800"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IFormalBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IFormalBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CF69E800"));
    }
}