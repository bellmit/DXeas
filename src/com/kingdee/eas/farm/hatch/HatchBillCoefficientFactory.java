package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchBillCoefficientFactory
{
    private HatchBillCoefficientFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficient getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficient)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8F8EB95C") ,com.kingdee.eas.farm.hatch.IHatchBillCoefficient.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficient getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficient)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8F8EB95C") ,com.kingdee.eas.farm.hatch.IHatchBillCoefficient.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficient getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficient)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8F8EB95C"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchBillCoefficient getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchBillCoefficient)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8F8EB95C"));
    }
}