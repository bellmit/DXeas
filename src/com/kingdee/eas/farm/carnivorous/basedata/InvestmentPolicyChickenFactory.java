package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InvestmentPolicyChickenFactory
{
    private InvestmentPolicyChickenFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3826E82E") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3826E82E") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3826E82E"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyChicken)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3826E82E"));
    }
}