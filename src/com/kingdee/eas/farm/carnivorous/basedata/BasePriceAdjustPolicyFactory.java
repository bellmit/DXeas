package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasePriceAdjustPolicyFactory
{
    private BasePriceAdjustPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5D3A3E57") ,com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5D3A3E57") ,com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5D3A3E57"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5D3A3E57"));
    }
}