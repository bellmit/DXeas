package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggCandlingBillFactory
{
    private EggCandlingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BF769488") ,com.kingdee.eas.farm.hatch.IEggCandlingBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IEggCandlingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BF769488") ,com.kingdee.eas.farm.hatch.IEggCandlingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BF769488"));
    }
    public static com.kingdee.eas.farm.hatch.IEggCandlingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IEggCandlingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BF769488"));
    }
}