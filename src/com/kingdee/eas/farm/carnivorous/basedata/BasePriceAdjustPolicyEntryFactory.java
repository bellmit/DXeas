package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasePriceAdjustPolicyEntryFactory
{
    private BasePriceAdjustPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BF2385B") ,com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BF2385B") ,com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BF2385B"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBasePriceAdjustPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BF2385B"));
    }
}