package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggCandlingBillFactory
{
    private BEggCandlingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D54999A2") ,com.kingdee.eas.farm.hatch.IBEggCandlingBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D54999A2") ,com.kingdee.eas.farm.hatch.IBEggCandlingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D54999A2"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggCandlingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggCandlingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D54999A2"));
    }
}